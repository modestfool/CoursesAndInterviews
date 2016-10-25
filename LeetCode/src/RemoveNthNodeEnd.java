/**
 * @author: basavakanaparthi
 * on 12,Oct,2016 at 4:16 PM.
 */
public class RemoveNthNodeEnd {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val= x;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;
        while(n > 0 && second != null)
        {
            second = second.next;
            n--;
        }
        printLL(second);
        while (second != null)
        {
            prev = first;
            first = first.next;
            second = second.next;
        }
        //System.out.println("--"+first.val);
        if(prev == null)
        {
            prev = first.next;
            head = prev;
        }

        else
            prev.next = first.next;
        return head;
    }
    public static void printLL(ListNode head)
    {
        while (head != null && head.next != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        if (head != null)
            System.out.println(head.val);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        printLL(head);
        head = removeNthFromEnd(head,1);
        printLL(head);
    }
}
