import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 24,Aug,2016 at 12:31 AM.
 */

/*
    Given a natural number n (1 <= n <= 500000), please output the summation of all its proper divisors.

    Definition: A proper divisor of a natural number is the divisor that is strictly less than the number.

    e.g. number 20 has 5 proper divisors: 1, 2, 4, 5, 10, and the divisor summation is: 1 + 2 + 4 + 5 + 10 = 22.



    Input

    An integer stating the number of test cases (equal to about 200000), and that many lines follow, each containing
    one integer between 1 and 500000 inclusive.

    Output

    One integer each line: the divisor summation of the integer given respectively.

    Example

    Sample Input:
    3
    2
    10
    20

    Sample Output:
    1
    8
    22
 */
public class DivisorSummation {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++)
        {
            int num = in.nextInt();
            int sum = 1;
            for (int j = 2; j < Math.sqrt(num); j++)
            {
                if (num % j == 0)
                {
                    sum += j + (num/j);
                }
            }
            int sqrt = (int) Math.sqrt(num);
            if (sqrt*sqrt == num)
                sum+= sqrt;
            System.out.println(sum);
        }
    }
}
