package GoDaddy;

import java.util.*;

/**
 * @author: basavakanaparthi
 * on 22,Sep,2016 at 2:17 PM.
 */
public class Subsequences {
    public static HashMap<String, List<String >> mapSubSequences = new HashMap<>();

    public static String[] getSubsequencesArr(String s)
    {
        List<String> ans = getSubsequences(s);
        Set<String> uniqueWords = new HashSet<>(ans);
        String[] ansArr =  uniqueWords.toArray(new String[uniqueWords.size()]);
        Arrays.sort(ansArr);
        return ansArr;

    }
    public static List<String> getSubsequences(String s) {
//        System.out.println("Input: " +s);
        ArrayList<String> ans = new ArrayList<>();
        if (s.length() == 0)
        {
            mapSubSequences.put(s, ans);
            return ans;
        }
        if (s.length() == 1) {
            ans.add(s);
            return ans;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            ans.add(String.valueOf(s.charAt(i)));
            List<String> localRes;
            String suffix = s.substring(1);
            if (mapSubSequences.containsKey(suffix)) {
                localRes = mapSubSequences.get(suffix);
            } else {
                localRes = getSubsequences(s.substring(1));
                mapSubSequences.put(s.substring(1), localRes);
            }
            // Add the results
            ans.add(s.substring(0, 0 + 1));
            ans.addAll(appendChar(s.charAt(0), localRes));
            ans.addAll(localRes);

        }
        return ans;
    }

    public static void printList(List<String> stringList)
    {
        System.out.println("Size: " + stringList.size());
        for (String s: stringList)
            System.out.println(s + " ");
//        System.out.println();
    }
    private static List<String> appendChar(char c, List<String> subsequences) {
//        printList(subsequences);
        String d;
        for (int i = 0; i < subsequences.size(); i++) {
            d = subsequences.get(i);
            d = c+d;
            subsequences.set(i, d);
        }
        return subsequences;
    }
    public static String[] getSubsequencesRec(String s)
    {
        HashSet<String> subseq = getSequences(s);
        String[] ans = new String[subseq.size()];
        subseq.toArray(ans);
        Arrays.sort(ans);
        return ans;
    }

    public static HashSet<String> getSequences(String s)
    {
        HashSet<String> subSeq = new HashSet<>();
        if (s.length() <= 1)
        {
            subSeq.add(s);
            return subSeq;
        }
        HashSet<String> subSubSeq = getSequences(s.substring(1));
        subSeq.add(String.valueOf(s.charAt(0)));
        subSeq.addAll(appendChar(s.charAt(0),subSubSeq ));
        subSeq.addAll(subSubSeq);
        return subSeq;
    }

    public static HashSet<String> appendChar(char c, HashSet<String> seq)
    {
        HashSet<String> ans = new HashSet<>();
        for(String s: seq)
        {
            ans.add(c+s);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        List<String> a = Arrays.asList(getSubsequencesRec(input));
        printList(a);
    }
}
