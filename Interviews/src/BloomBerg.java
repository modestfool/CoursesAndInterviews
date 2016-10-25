import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 1:58 AM.
 */
public class BloomBerg {

    public static String longestPalindromicString(String s)
    {
        int i;
        int j;

        int maxLen = 0;
        int ind = -1;
        for(int k = 1; k < s.length() - 1; k++)
        {
            i = k - 1;
            j = k + 1 ;
            System.out.println(k + " " + s.charAt(i) +" " + s.charAt(j));
            while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j))
            {
                System.out.println(k + " " + i +" " + j);
                j++;
                i--;

            }

            if(j - i + 1 > maxLen) {
//                System.out.println(i +" " + j);
                maxLen = j - i + 1;
                ind = i + 1;
            }
        }
//        System.out.println(maxLen + " " + ind);
        return s.substring(ind, ind + maxLen);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(longestPalindromicString(in.next()));
    }
}
