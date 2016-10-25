package WorldQuant;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: basavakanaparthi
 * on 21,Sep,2016 at 4:28 PM.
 */
public class ReachingPoints {
    /*
 * Complete the function below.
 */

    static String canReach(int a, int b, int c, int d)
    {
        if (a> c && b>d)
            return "No";
        List<Point> queue = new LinkedList<>();
        Point start = new Point(a,b);
        Point dest = new Point(c,d);

        queue.add(start);

        while(!queue.isEmpty())
        {
            Point curr = queue.remove(0);
            System.out.println(curr.x + " " + curr.y);
            if(checkReached(curr, dest))
                return "Yes";
            if (curr.x > dest.x && curr.y > dest.y)
                continue;
            int newX = curr.x + curr.y;
            if (newX <= dest.x)
                queue.add(new Point(newX, curr.y));
            if (newX <= dest.y)
                queue.add(new Point(curr.x, newX));

        }
        return "No";
    }

    static boolean checkReached(Point a, Point b)
    {
        return a.x == b.x && a.y == b.y;
    }
    public static void main(String[] args)
    {
        System.out.println(canReach(1,4, 5,9));
    }
}
class Point
{
    int x, y;
    Point(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
}
