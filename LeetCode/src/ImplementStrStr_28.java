/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 10:03 PM.
 */
/*
    Implement strStr().

    Returns the index of the first occurrence of needle in haystack,
     or -1 if needle is not part of haystack.
 */
public class ImplementStrStr_28
{
    public static int strStr(String haystack, String needle)
    {
        for (int i = 0; ; i++)
        {
            for (int j = 0; ; j++)
            {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println(strStr("mississippi", "issip"));
    }
}
