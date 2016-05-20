/**
 * 
 */
package nlp4j.nlp4j;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import edu.emory.mathcs.nlp.common.util.IOUtils;
import edu.emory.mathcs.nlp.common.util.Joiner;
import edu.emory.mathcs.nlp.component.template.node.NLPNode;
import edu.emory.mathcs.nlp.decode.NLPDecoder;
import edu.emory.mathcs.nlp.tokenization.EnglishTokenizer;
import edu.emory.mathcs.nlp.tokenization.Tokenizer;

/**
 * Demo.java 
 * @author Basava R.Kanaparthi(basava.08@gmail.com)
 * Created on Mar 30, 2016
 */
public class Demo {
		static public void main(String[] args) throws Exception
		{
			//final String configFile = "/Users/jdchoi/Documents/EmoryNLP/nlp4j/src/main/resources/edu/emory/mathcs/nlp/configuration/config-decode-en.xml";
			//final String inputFile  = "/Users/jdchoi/Documents/EmoryNLP/nlp4j/src/test/resources/dat/nlp4j.txt";
			final String configFile = "/Users/basavakanaparthi/Desktop/config-decode-en.xml";
			final String inputFile = "/Users/basavakanaparthi/Desktop/input.txt";
			
			final String impressionsPath = "/Users/basavakanaparthi/Documents/odrive/Google Drive"
									+ "/Stony Brook/Stony Brook University/Spring 2016/CSE 523 Adv. Proj IV/"
										+ "data/parser output/impressions_rtf";
			final String outputPath = "/Users/basavakanaparthi/Documents/odrive/Google Drive"
					+ "/Stony Brook/Stony Brook University/Spring 2016/CSE 523 Adv. Proj IV/"
					+ "data/parser output/dependency tree_rtf";
			
			String[] impressionFiles = new File(impressionsPath).list(null);
			NLPDecoder nlp4j = new NLPDecoder(IOUtils.createFileInputStream(configFile));

			Tokenizer tokenizer = new EnglishTokenizer();
			NLPNode[] nodes;
			List<NLPNode[]> sentences;
			
			OutputStream out;
			
			Pattern re = Pattern.compile
					("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", 
							Pattern.MULTILINE | Pattern.COMMENTS);
			String list = "^[\\d]+\\.";
			Pattern list_item = Pattern.compile(list);
			for (String f : impressionFiles)
			{
				if(f.endsWith(".txt"))
				{
					String filename = f.split(".txt")[0];//f.getName();	
					out = new BufferedOutputStream(new FileOutputStream(outputPath + "/" + f ));
					System.out.println("\n" + f);
					//InputStream in = IOUtils.createFileInputStream(impressionsPath + "/" + f);
					BufferedReader in = IOUtils.createBufferedReader(impressionsPath + "/" + f);
					String line;
					StringBuilder textBuilder = new StringBuilder();
					while((line = in.readLine()) != null)
					{
//						StringBuilder sb = new StringBuilder();
						String line_lower = line.toLowerCase();
						if (line_lower.contains("impression" ))
							line = line + ".";
					    Matcher reMatcher = re.matcher(line.trim());
					    while (reMatcher.find()) {
					    	String g = reMatcher.group();
					    	if(g.matches(list))
					    	{
					    		System.out.println("---------------");
//					    		sb.append(g);
//					    		sentences = tokenizer.tokenize(g);
//					    		out.write(("\n-------" + g + "--------\n").getBytes());
					    		System.out.println(g);
					    		System.out.println("---------------");
					    		continue;
					    	}
//					    	System.out.println(g);
//					    	sb = new StringBuilder();
					    	textBuilder.append(g+"\n");
					    	
					    }
//						tokens = tokenizer.tokenize(line);
//						System.out.println(Joiner.join(tokens, " "));
					}
					String text = textBuilder.toString();
					System.out.println(text);
					sentences = tokenizer.segmentize(text);
					for(NLPNode[] sentence:sentences)
					{
						nodes = nlp4j.decode(sentence);
						String n = Joiner.join(nodes, "\n", 1);
						System.out.println();
						System.out.println(n);
						out.write((n + "\n\n\n").getBytes());
					}
//			    	out.write((n + "\n\n\n").getBytes());
					out.flush();
					out.close();
//					for (NLPNode[] tokens : tokenizer.segmentize(in))
//					{
//						System.out.println(Joiner.join(tokens, " "));
//					}
//					nlp4j.decode(in, out, NLPDecoder.FORMAT_LINE);
//					in.close();
//					break;
				}
			}
//			NLPDecoder nlp4j = new NLPDecoder(IOUtils.createFileInputStream(configFile));

			
//			Files.walk(Paths.get(impressionsPath))
//		     .filter(Files::isRegularFile)
//		     .forEach(System.out::println);
			
//			String sentence = "One John bought a car for Mary"
//					+ ".This is the second sentence. "
//					+ "And 3 is this sentence's number.";
//			nodes = nlp4j.decode(sentence);
//			System.out.println(Joiner.join(nodes, "\n", 1));
//			nlp4j.decode(IOUtils.createFileInputStream(inputFile), System.out, NLPDecoder.FORMAT_RAW);
		}
}
