import java.util.Arrays;

/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 1:32 AM.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int newSum = digits[i] + carry;
            digits[i] = (newSum) % 10;
            carry = newSum/10;
            if (newSum < 10)
                break;
            System.out.println(carry);
        }

        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
