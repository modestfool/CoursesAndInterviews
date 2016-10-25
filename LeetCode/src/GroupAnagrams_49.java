import java.util.*;

/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 5:33 AM.
 */
/*
    https://leetcode.com/problems/anagrams/
    Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

    [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note: All inputs will be in lower-case.
 */
public class GroupAnagrams_49
{
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List<String>> anagramGroups= new  HashMap<>();
        for(String s: strs)
        {
            char[] key = s.toCharArray();
            Arrays.sort(key);
            String k = String.valueOf(key);
            if (anagramGroups.containsKey(k)) {
                List<String> group = anagramGroups.get(k);
                group.add(s);
                Collections.sort(group);
            }
            else
            {
                ArrayList<String> group = new ArrayList<>();
                group.add(s);
                Collections.sort(group);
                anagramGroups.put(k, group);
            }
        }
        // System.out.println(anagramGroups.toString());
        ArrayList<List<String>> groups = new ArrayList<List<String>>(anagramGroups
                .values());

        Collections.sort(groups, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                if (o1.size() != o2.size())
                    return o1.size() - o2.size();
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return groups;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = in.next();
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(groupAnagrams(arr));
    }
}
