/**
 *
 */
package stanfordParser;

/**
 * DependencyParserDemo.java 
 * @author Basava R.Kanaparthi(basava.08@gmail.com)
 * Created on Apr 1, 2016
 */

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.util.logging.Redwood;

import java.io.*;
import java.util.List;

public class DependencyParserDemo  {

    /** A logger for this class */
    private static Redwood.RedwoodChannels log = Redwood.channels(DependencyParserDemo.class);

    public static void main(String[] args) {
        String modelPath = DependencyParser.DEFAULT_MODEL;
        String taggerPath = "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger";

        for (int argIndex = 0; argIndex < args.length; ) {
            switch (args[argIndex]) {
                case "-tagger":
                    taggerPath = args[argIndex + 1];
                    argIndex += 2;
                    break;
                case "-model":
                    modelPath = args[argIndex + 1];
                    argIndex += 2;
                    break;
                default:
                    throw new RuntimeException("Unknown argument " + args[argIndex]);
            }
        }

        String text = "I can almost always tell when movies use fake dinosaurs.";

        MaxentTagger tagger = new MaxentTagger(taggerPath);
        DependencyParser parser = DependencyParser.loadFromModelFile(modelPath);

        final String impressionsPath = "/Users/basavakanaparthi/Documents/odrive/Google Drive"
                + "/Stony Brook/Stony Brook University/Spring 2016/CSE 523 Adv. Proj IV/"
                + "data/parser output/impressions";
        final String outputPath = "/Users/basavakanaparthi/Documents/odrive/Google Drive"
                + "/Stony Brook/Stony Brook University/Spring 2016/CSE 523 Adv. Proj IV/"
                + "data/parser output/stanford nlp";

        File[] impressionFiles = new File(impressionsPath).listFiles();
        OutputStream impout;
        PrintStream pout;
        PrintStream console = new PrintStream(System.out);

        assert impressionFiles != null;
        for (File f : impressionFiles)
        {
            if(f.isFile() && f.getName().endsWith(".txt"))
            {
                String filename = f.getName();	//.split(".txt")[0];
                try {
                    impout = new BufferedOutputStream(new FileOutputStream(outputPath + "/" + filename ));
                    pout = new PrintStream(impout, true);

                    System.setOut(console);
                    System.out.println(filename);

                    InputStream in = new FileInputStream(f);
                    Reader reader = new InputStreamReader(in);
                    DocumentPreprocessor tokenizer = new DocumentPreprocessor(reader);

                    // Update the sout filestream.
                    System.setOut(pout);

                    for (List<HasWord> sentence : tokenizer) {
                        List<TaggedWord> tagged = tagger.tagSentence(sentence);
                        for (TaggedWord taggedWord : tagged) {
				    	  System.out.println(taggedWord);
                        }

                        GrammaticalStructure gs = parser.predict(tagged);
//                        GrammaticalStructure.dependenciesToCoNLLXString(gs.typedDependencies()  );
                        System.out.println(gs.typedDependenciesCollapsed());
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


//			break;
            }
        }

    }
}