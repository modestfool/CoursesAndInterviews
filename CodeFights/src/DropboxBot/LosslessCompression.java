package DropboxBot;

import java.util.ArrayList;

/**
 * @author: basavakanaparthi
 * on 07,Oct,2016 at 1:21 AM.
 */
public class LosslessCompression
{
    static int startInd = -1;
    String losslessDataCompression(String inputString, int width)
    {
        ArrayList<Character> window = new ArrayList<>();
        StringBuilder compressed = new StringBuilder();
        char[] input = inputString.toCharArray();
        for(int i = 0; i < input.length; i++)
        {
            int lcs = getLongestCommonSubstring(inputString.substring(i),getStringRepresentation(window));
            System.out.println("LCS: " + lcs);
            if (lcs == 0)
                window.add(input[i]);
            else {
               for(int k = i; k <= lcs; k++)
                   window.add(input[k]);
            }
            if (lcs<= 1)
            {
                compressed.append(input[i]);

            }
            else
            {
                compressed.append(String.format("(%d,%d)",startInd,lcs));
                i += lcs;
            }
            while(window.size() > width)
                window.remove(0);
        }
        return compressed.toString();

    }
    String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    int getLongestCommonSubstring(String b, String a){
        int m = a.length();
        int n = b.length();

        int max = 0;
        startInd = -1;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j] = dp[i-1][j-1]+1;
                    }

                    if(max < dp[i][j])
                    {
                        max = dp[i][j];
                        startInd = i;
                    }
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LosslessCompression().losslessDataCompression
                ("abacabadabacaba",7));
    }
}
