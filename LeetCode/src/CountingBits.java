import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 25,Oct,2016 at 1:52 AM.
 */
public class CountingBits {
    public static int[] countBits(int num)
    {
        int[] oneBits = new int[num+1];
        oneBits[0] = 0;
        for (int i = 1; i <= num; i++)
        {
            oneBits[i] = getOneBits(i);
        }
        return oneBits;
    }

    public static int getOneBits(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }
}
