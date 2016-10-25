package com.sbu.mdlog;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class InfoRetrieval {

	static Map<String, String> posmap = new HashMap<String, String>();

	public static void main(String[] args) {

		String input = args[0].trim();
		input = input.toLowerCase();

		getPOSTags(input);
		parser(input);
	}

	public static void parser(String sentence) {

		List<Tree> np = new ArrayList<Tree>();
		List<Tree> vp = new ArrayList<Tree>();

		List<String> verbs = new ArrayList<String>();
		verbs.add("VB");
		verbs.add("VBP");
		verbs.add("VBD");
		verbs.add("VBN");
		verbs.add("VBZ");
		verbs.add("RB");
		verbs.add("VBG");

		List<String> adjs = new ArrayList<String>();
		adjs.add("JJ");
		adjs.add("JJS");
		adjs.add("JJR");
		adjs.add("CD");

		List<String> nouns = new ArrayList<String>();
		nouns.add("NN");
		nouns.add("NNS");
		nouns.add("NNP");
		nouns.add("NNPS");

		String actionVerb = "";
		String context = "";
		String object = "";

		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
		lp.setOptionFlags(new String[] { "-maxLength", "500", "-retainTmpSubcategories" });

		TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(), "");
		List<CoreLabel> rawWords2 = tokenizerFactory.getTokenizer(new StringReader(sentence)).tokenize();
		Tree parse = lp.apply(rawWords2);

		Iterator<Tree> it = parse.iterator();
		while (it.hasNext()) {
			Tree tmp = it.next();
			String label = tmp.label().toString();
			if (label.equals("NP")) {
				np.add(tmp);
			} else if (label.equals("VP") || label.equals("ADVP")) {
				vp.add(tmp);
			}
		}

		for (Tree tree : vp) {

			Iterator<Tree> tmpit = tree.iterator();
			while (tmpit.hasNext()) {
				Tree tmp = tmpit.next();
				String label = tmp.label().toString();

				if (verbs.contains(label)) {
					String t = tmpit.next().label().toString();

					if (verbs.contains(posmap.get(t)) && !actionVerb.contains(t)) {
						actionVerb += t + " ";
					} else if (adjs.contains(posmap.get(t)) && !context.contains(t)) {
						context += t + " ";
					}
				}
			}
		}
		for (Tree tree : np) {
			Iterator<Tree> tmpit = tree.iterator();
			while (tmpit.hasNext()) {

				String t = tmpit.next().label().toString();
				if (nouns.contains(posmap.get(t)) && !object.contains(t))
					object += t + " ";

				if (adjs.contains(posmap.get(t)) && !context.contains(t))
					context += t + " ";

			}

		}

		System.out.println(" __________________________ RESULTS ______________________________");
		System.out.println("Action Verb = " + actionVerb);
		System.out.println("Object = " + object);
		System.out.println("Context = " + context);

	}

	public static void getPOSTags(String sent) {

		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		Annotation annotation = new Annotation(sent);
		pipeline.annotate(annotation);

		List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

		for (CoreMap sentence : sentences) {

			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				String word = token.get(TextAnnotation.class);
				String pos = token.get(PartOfSpeechAnnotation.class);
				posmap.put(word, pos);
			}
		}
	}
}