/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 3:04 AM.
 */
public class Number1Bits {

    public static int hammingWeight(int n)
    {
        int count = 0;
        while(n != 0)
        {
            if ((n&1) == 1)
                count++;
            n >>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(hammingWeight(2147483648));
    }
}
