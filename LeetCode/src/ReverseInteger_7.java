/**
 * @author: basavakanaparthi
 * on 27,Sep,2016 at 3:18 AM.
 */

/**
 *
 * Reverse digits of an integer.
 *  Example1: x = 123, return 321
 *  Example2: x = -123, return -321
 */
public class ReverseInteger_7 {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0)
        {
            if(Math.abs(ans) > Math.abs(Integer.MAX_VALUE/10))
                return 0;
            ans = ans*10 + x%10;
            x = x/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( new ReverseInteger_7().reverse(1534236469));
    }
}
