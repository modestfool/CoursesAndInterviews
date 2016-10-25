package Coursera;

import java.util.Scanner;
import java.util.*;

/**
 * @author: basavakanaparthi
 * on 13,Sep,2016 at 2:55 AM.
 */
public class NonDominatable {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Entity[] entities = new Entity[n];
        for (int i = 0; i < n; i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            Entity temp = new Entity(x,y);
            entities[i] = temp;
        }
        Arrays.sort(entities, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2)  {
            if (o2.getX() - o1.getX() == 0)
                return o1.getY() - o2.getY();
            else
                return o2.getX() - o1.getX();
        }
        });
        int count = 0;
        int maxY = Integer.MIN_VALUE;
        for (Entity e: entities)
        {
//            System.out.println(e.getX() + " " + e.getY());
            if (e.getY() >= maxY)
            {
                count++;
                maxY = e.getY();
            }
        }

        System.out.println(count);
    }


}

class Entity {
    private Integer x, y;

    Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}