import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: basavakanaparthi
 * on 20,Sep,2016 at 2:26 AM.
 */
public class GrubHub
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = in.nextInt();
        System.out.println(getNonDuplicateSet(arr));
    }

    private static int getNonDuplicate(int[] arr) {
        int ans = 0;
        for(int i : arr)
        {
            ans = ans^i;
        }
        return ans;
    }

    private static int getNonDuplicateSet(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr)
        {
            if (s.contains(i))
                s.remove(i);
            else
                s.add(i);
        }
        return s.iterator().next();
    }
}
