package WorldQuant;

import java.util.HashSet;

/**
 * @author: basavakanaparthi
 * on 21,Sep,2016 at 1:49 PM.
 */
public class RemoveRedundancyLL {

    class Node{
        int data;
        Node next;

    }
    void removeDuplicates(Node head)
    {
        HashSet<Integer> hs = new HashSet<>();
        Node tmp = head;
        Node prev = head;
        while (tmp!= null)
        {
            if (hs.contains(tmp.data))
            {
                prev.next = tmp.next;
                tmp = tmp.next;
            }
            else
            {
                hs.add(tmp.data);
                prev = tmp;
                tmp = tmp.next;

            }
        }
    }
}
