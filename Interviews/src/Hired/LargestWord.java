package Hired;

/**
 * @author: basavakanaparthi
 * on 24,Oct,2016 at 7:36 PM.
 */
public class LargestWord {
    public static int solution(String S) {
        // write your code in Java SE 8
        String[] sentences = S.split("\\?|\\.|\\!");
//        System.out.println(Arrays.toString(sentences));
        int sentenceLen = 0;
        for (String sentence : sentences)
        {
            String[] words = sentence.split(" ");
//            System.out.println(Arrays.toString(words));
            int localLen = 0;
            for(String word : words)
            {
                if (word.matches(".*[a-zA-Z]+.*"))
                    localLen++;
            }
            if (localLen > sentenceLen)
                sentenceLen = localLen;
        }
        return sentenceLen;
    }

    public static void main(String[] args) {
        System.out.println(solution("We test coders. Give us a try?"));
        System.out.println(solution("Forget  CVs..Save time . x x"));
        System.out.println(solution(""));
    }

}
