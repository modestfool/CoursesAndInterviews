import java.util.HashMap;

/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 4:07 PM.
 */
public class NumberToHex {
    public static String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Character> hexMap = new HashMap<>();
        hexMap.put(10, 'a');
        hexMap.put(11, 'b');
        hexMap.put(12, 'c');
        hexMap.put(13, 'd');
        hexMap.put(14, 'e');
        hexMap.put(15,'f');
        while (num != 0) {
            int nextBit = Math.floorMod(num,16);
            System.out.println("nextBit:" + nextBit);
            if (nextBit > 9)
                sb.append(hexMap.get(nextBit));
            else
                sb.append(nextBit);
            num = num / 16;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }
}
