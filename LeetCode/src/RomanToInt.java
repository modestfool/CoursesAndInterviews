import java.util.HashMap;

/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 12:04 AM.
 */
public class RomanToInt {
    public static int romanToInt(String s)
    {
        HashMap<Character, Integer> romanToValue = new HashMap<>();
        romanToValue.put('I', 1);
        romanToValue.put('V', 5);
        romanToValue.put('X', 10);
        romanToValue.put('L', 50);
        romanToValue.put('C', 100);
        romanToValue.put('D', 500);
        romanToValue.put('M', 1000);

        int prevVal = romanToValue.get(s.charAt(s.length()-1));
        int val = prevVal;
        int j = s.length()-2;
        while(j >= 0)
        {
            char c = s.charAt(j);
            int currVal = romanToValue.get(c);
            if ( currVal < prevVal)
                val -= currVal;
            else
                val += currVal;

            prevVal = currVal;
            j--;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XXIX"));
    }

}
