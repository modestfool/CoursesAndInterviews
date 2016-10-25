package VMware;

/**
 * @author: basavakanaparthi
 * on 28,Sep,2016 at 3:32 PM.
 */
public class LonelyInteger
{
    /*
    * Complete the function below.
 */
    // Only one duplicate. Rest are repeated in even multiples.
    static int lonelyInteger(int[] arr) {
        int ans = 0;
        for (int i : arr)
            ans = ans^i;
        return ans;
    }
}
