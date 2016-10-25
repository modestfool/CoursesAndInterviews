/**
 * @author: basavakanaparthi
 * on 25,Oct,2016 at 12:18 AM.
 */
/*
    Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers
{
    public int compareVersion(String version1, String version2)
    {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int compare = version1Arr[0].compareTo(version2Arr[0]);
        if (compare == 0)
        {
            int i = 1;
            int len = Math.min(version1Arr.length, version2Arr.length);
            int maxLen = Math.max(version1Arr.length, version2Arr.length);
            while (i < len && compare == 0)
            {
                compare = version1Arr[i].compareTo(version2Arr[i]);
                i++;
            }
            if (compare == 0 && i < maxLen)
                return version1Arr.length - version2Arr.length;
        }
        return compare;
    }
}
