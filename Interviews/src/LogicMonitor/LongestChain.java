package LogicMonitor;

/**
 * @author: basavakanaparthi
 * on 19,Oct,2016 at 4:08 PM.
 */
    import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
    Given an array, words, of n word
    strings (words[0], words[1], …, words[n−1]),
    choose a word from it and, in each step,
    remove a single letter from the chosen word if
    and only if doing so yields another word that is already in the library.
    Each successive character removal should be performed on the result of
    the previous removal, and you cannot remove a character if the resulting
    string is not an element in words (see the Explanation below for detail).
    The length of a string chain is the maximum number of strings in a chain of
    successive character removals.

    Complete the longestChain function in your editor.
    It has 1 parameter: an array of n strings, words, where the value of each element wordsi (where 0 ≤ i < n) is a word. It must return a single integer denoting the length of the longest possible string chain in words.

 */
public class LongestChain {
        /*
         * Complete the function below.
         */
        static int longestChain(String[] words) {
            Map<String, Integer> result = new HashMap<>();
            int max = -1;
            Arrays.sort(words, new Comparator<String>()
            {
                @Override
                public int compare(String o1, String o2)
                {
                    return o1.length() - o2.length();
                }
            });

            for (String word : words)
            {
                int localMax = -1;
                if(word.length() >=2)
                {
                    for (int i = 0; i < word.length(); i++)
                    {

                        String transformed = word.substring(0,i) + word.substring(i + 1,word.length());
                        if (result.containsKey(transformed))
                        {
                            localMax = Math.max(localMax, 1 + result.get(transformed));
                        }
                    }
                    max = Math.max(localMax, max);
                }
                localMax = (localMax > 0) ?localMax: 1;
                result.put(word, localMax);
            }
            return max;
        }

        public static void main(String[] args) throws IOException{
            Scanner in = new Scanner(System.in);
            final String fileName = System.getenv("OUTPUT_PATH");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            int res;

            int _words_size = 0;
            _words_size = Integer.parseInt(in.nextLine().trim());
            String[] _words = new String[_words_size];
            String _words_item;
            for(int _words_i = 0; _words_i < _words_size; _words_i++) {
                try {
                    _words_item = in.nextLine();
                } catch (Exception e) {
                    _words_item = null;
                }
                _words[_words_i] = _words_item;
            }

            res = longestChain(_words);
            bw.write(String.valueOf(res));
            bw.newLine();

            bw.close();
        }
    }

