import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 20,Aug,2016 at 5:04 PM.
 */
public class A_plus_B {

    public static int sum(int a, int b)
    {
        return a+b;
    }

    public static void main(String[] args)
    {
        int a, b;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(sum(a, b));
    }
}
