import java.util.*;

/**
 * @author: basavakanaparthi
 * on 20,Aug,2016 at 5:20 PM.
 */
/*
 *
 * Donald Duck works as a postman for the Walt Disney Studios.
 * He delivers children’s letters from all over the world to his friends, which are cartoon characters.
 * The Studios has three cases for the letters, with nine sections in each case.
 * Every section has the name of the receiver on it.
 * All cases stand in a row as it is shown at the picture below.
 * Donald Duck have brought n letters today. Initially, he stands near the leftmost case.
 * He has to make one step to go to the neighboring case or to the previous one.
 * How many steps will he make until he puts all the letters into the respective sections,
 *  if he does this in the order they are in his bag?
 *
 */
public class DonaldPostman {
    public static void main(String[] args) {
        int steps = 0;
        int currentPos = 0;
        List<String> case1 = Arrays.asList(
                        "Alice", "Ariel", "Aurora",
                        "Phil", "Peter", "Olaf",
                        "Phoebus", "Ralph", "Robin"
                );
        List<String> case2 = Arrays.asList(

                        "Bambi", "Belle", "Bolt",
                        "Mulan", "Mowgli", "Mickey",
                        "Silver", "Simba", "Stitch"
        );
        List<String> case3 = Arrays.asList(
                        "Dumbo", "Genie", "Jiminy",
                        "Kuzko", "Kida", "Kenai",
                        "Tarzan", "Tiana", "Winnie"
        );
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t > 0)
        {
            String recipient = in.nextLine();
            if (case1.contains(recipient))
            {
                steps += Math.abs(currentPos - 0);
                currentPos = 0;
            }
            else if (case2.contains(recipient))
            {
                steps += Math.abs(currentPos - 1);
                currentPos = 0;
            }
            else if (case3.contains(recipient))
            {
                steps += Math.abs(currentPos - 2);
                currentPos = 2;
            }
            t--;
        }
        System.out.println(steps);
    }
}
