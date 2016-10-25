import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: basavakanaparthi
 * on 20,Sep,2016 at 3:07 PM.
 */
public class IntegerToRoman {

    public static String intToRoman(int num)
    {
        TreeMap<Integer, String> intToRoman = new TreeMap<>();
        intToRoman.put(1,"I");
        intToRoman.put(5,"V");
        intToRoman.put(10,"X");
        intToRoman.put(50,"L");
        intToRoman.put(100,"C");
        intToRoman.put(500,"D");
        intToRoman.put(1000,"M");
        System.out.println(num);
        // Base cases
        if (num <=0)
            return "";
        if (intToRoman.containsKey(num))
            return intToRoman.get(num);

        StringBuilder roman = new StringBuilder();
        while(num > 0) {
            System.out.println(num);
            Integer l = intToRoman.floorKey(num);
            Integer r = intToRoman.ceilingKey(num);

            if (r == null)
                r = l;
            if (l == null)
                l = r;
            Integer pl = intToRoman.floorKey(l - 1);
            if (pl == null) {
                System.out.println(l + ": " + pl);
                pl = l; // Get the previous number to the lowest.
            }
            System.out.println("num: " + num + " pl: " + pl + " l: " + l + " r: " + r);
            if (num >= 4 * l)
            {
                roman.append(intToRoman.get(l)).append(intToRoman.get(r));
                num -= (r-l);
            }
            else if (num - l*(num/l) >= 4 * pl) {
                roman.append(intToRoman.get(pl)).append(intToRoman.get(r));
                num -= (r-pl);
            }
            else {
                roman.append(intToRoman.get(l));
                num -= l;
            }
        }
        System.out.println(roman.toString());
        return roman.toString();
    }
    public static String intToRoman_hack(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(intToRoman(in.nextInt()));
    }
}
