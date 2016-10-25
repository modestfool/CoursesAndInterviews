package Google;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 23,Sep,2016 at 8:08 PM.
 */
public class SumPaths {
    public static int getSumPaths(String path)
    {
        HashMap<Integer, Integer> levelsMap= new HashMap<>();
        String[] pathsArr = path.split("\n");
        int len = 0;
        int prevLevel = 0;
        int currLevel = 0;
        int maxLen = 0;
        for(String p: pathsArr)
        {
            //System.out.println(p);
            len = 0;
            String[] levels = p.split(" ");
            currLevel = levels.length;
            if (levels[currLevel-1].contains(".jpeg") || levels[currLevel-1].contains(".png")
                    || levels[currLevel-1].contains(".gif") )
            {
//                for(Map.Entry e: levelsMap.entrySet())
//                {
//                    if((int)e.getKey() < currLevel)
//                    {
//                        len += (Integer) e.getValue();
//                    }
//                }
                len += levelsMap.getOrDefault(currLevel-1,0);
                len += levels[currLevel-1].length();
                len += currLevel - 1;
                if (len > maxLen)
                    maxLen = len;
                System.out.println("Local Length: " + len + " " + levels[currLevel-1]);
            }
            if (currLevel < prevLevel)
                levelsMap.remove(prevLevel);
            prevLevel = currLevel;
            levelsMap.put(currLevel, levelsMap.getOrDefault(currLevel-1,0) + levels[currLevel-1].length());
        }
        return maxLen;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
//        String path = in.next();
        String path = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
//        String path = "dir1"+ "\n dir11"+ "\n dir12"+ "\n  picture.jpeg"+
//                "\n  dir121"+
//                "\n  file1.txt"+
//                "\ndir345"+
//                "\n dir23"+
//                "\n  ba.png"+
//                "\ndir2378"+
//                "\n dir5678"+
//                "\n  dir3456"+
//                "\n   hi.png";
        System.out.println(getSumPaths(path));
    }
}
