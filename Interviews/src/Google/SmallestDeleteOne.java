package Google;

import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 23,Sep,2016 at 8:45 PM.
 */
public class SmallestDeleteOne {
    public static int getSmallest(int x)
    {
        String s = String.valueOf(x);
        int ans = x;
        int localAns = x;
        for(int i =0; i < s.length()-1;i++)
        {
            if(s.charAt(i) < s.charAt(i+1))
            {
                localAns = Integer.valueOf(s.substring(0,i) + s.substring(i+1));
            }
            else
                localAns = Integer.valueOf(s.substring(0,i+1) + s.substring(i+2));
            if (localAns < ans)
                ans = localAns;
        }
        return ans;
    }

    public static int solution(int X) {
        // write your code in Java SE 8
        String s = String.valueOf(X);
        int ans = Integer.MIN_VALUE;
        int localAns = X;
        for(int i= 1; i < s.length()-1;i++)
        {
            double avg = Integer.valueOf(s.substring(i-1,i))+ Integer.valueOf(s.substring(i,i+1));
            int a = (int)Math.ceil(avg/2);
//            System.out.println(a);
            localAns = Integer.valueOf(s.substring(0,i-1)+ a + s.substring(i+1));
//            System.out.println(localAns);
            if (localAns>ans)
                ans = localAns;
        }
        return ans;

    }

    public static int solution2(int X) {
        // Base case
        if (X < 10)
            return 0;
        String s = String.valueOf(X);
        int ans = Integer.MIN_VALUE;
        int localAns;
        for(int i = 1; i < s.length();i++)
        {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i,i+1));
            double sum = first+second;
            int avg = (int)Math.ceil(sum/2);
            localAns = Integer.valueOf(s.substring(0,i-1)+ avg + s.substring(i+1));

            if (localAns > ans)
                ans = localAns;
            if( avg > first)
                return ans;
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(solution2(in.nextInt()));
    }
}
