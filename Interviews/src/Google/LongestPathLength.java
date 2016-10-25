package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 23,Sep,2016 at 8:08 PM.
 */
public class LongestPathLength {
    public static int getSumPaths(String path) {
        HashMap<Integer, Integer> levelsMap = new HashMap<>();
        String[] pathsArr = path.split("\n");
        int len = 0;
        int prevLevel = 0;
        int currLevel = 0;
        int maxLen = 0;
        for (String p : pathsArr) {
            len = 0;
            //System.out.println(p);
            String[] levels = p.split("\t");
            currLevel = levels.length;
            //System.out.println(levels[currLevel-1] + " :" + currLevel);
//            if (levels[currLevel-1].contains(".jpeg") || levels[currLevel-1].contains(".png"))
            if (levels[currLevel - 1].contains(".")) {
                for (Map.Entry e : levelsMap.entrySet()) {
                    if ((int) e.getKey() < currLevel) {
                        len += (Integer) e.getValue();//((String) e.getValue()).length();
//                        System.out.print(e.getValue() +"/");
                    }
                }
                len += levels[currLevel - 1].length();
                len += currLevel - 1;
                if (len > maxLen)
                    maxLen = len;
//                System.out.print(levels[currLevel-1]);
//                System.out.println();
            }
            if (currLevel < prevLevel)
                levelsMap.remove(prevLevel);
            prevLevel = currLevel;
            levelsMap.put(currLevel, levels[currLevel - 1].length());
        }
        return maxLen;
    }
    // you can also use imports, for example:
// import java.util.*;

    // you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
    public static int solution(String S){
    // Keep the current cumulative path length till this level.
    HashMap<Integer, Integer> levelsMap = new HashMap<>();
    // Split into directories.
    String[] pathsArr = S.split("\n");
    int prevLevel = 0;
    int currLevel = 0;
    int maxLen = 0; // default value
        for(
    String p:pathsArr)

    {
        int len = 0; // reset the length.
        // Get the levels
        String[] levels = p.split(" ");
        currLevel = levels.length;
        if (levels[currLevel - 1].contains(".jpeg") || levels[currLevel - 1].contains(".png")
                || levels[currLevel - 1].contains(".gif")) {
            len += levelsMap.getOrDefault(currLevel - 1, 0);
            len += (currLevel - 1 > 0) ? currLevel - 1 : 1; // Append number of slashes.
            if (len > maxLen)
                maxLen = len;
        }
        if (currLevel < prevLevel)
            levelsMap.remove(prevLevel);
        prevLevel = currLevel;
        levelsMap.put(currLevel, levelsMap.getOrDefault(currLevel - 1, 0) + levels[currLevel - 1].length());
    }
        return maxLen;
}

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
//        String path = in.next();
        String path = "dir1\\n dir11\\n dir12\\n  picture.jpeg\\n  dir121\\n  file1.txt\\ndir2\\n file2.gif";//"dir1"+ "\n dir11"+ "\n dir12"+ "\n  picture.jpeg"+
        System.out.println(path);
//                "\n  dir121"+
//                "\n  file1.txt"+
//                "\ndir345"+
//                "\n dir23"+
//                "\n  ba.png"+
//                "\ndir2378"+
//                "\n dir5678"+
//                "\n  dir3456"+
//                "\n   hi.png";
        System.out.println(solution(path));
    }
}
