package HackerRank;

/**
 * @author: basavakanaparthi
 * on 24,Oct,2016 at 2:56 AM.
 */
public class CountBinarySubStrings {
    static int count(String s)
    {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i+2; j <= s.length(); j += 2)
            {
                String sub = s.substring(i,j);
                if (isValid(sub)) {
//                    System.out.println(s.substring(i,j));
                    count++;
                }
                }
        }
        return count;
    }

    static boolean isValid(String s)
    {
        System.out.println("Substring: " + s);
        if (s == null)
            return true;

        char prev = s.charAt(0);
        int diff = (prev == '1')? 1 : -1;
        int flips = 0;
        for(int i = 1; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '1')
                diff++;
            else
                diff--;

            if (Math.abs(diff) > s.length() - i)
                return false;

            if (prev != c)
                flips++;
            prev = c;
            if(flips > 1) {
//                System.out.println(s + " " + flips);
                return false;
            }
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        System.out.println(count("00110"));
    }
}
