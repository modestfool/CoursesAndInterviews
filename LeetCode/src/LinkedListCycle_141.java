import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 02,Oct,2016 at 11:23 PM.
 */
public class LinkedListCycle_141 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(slow!= null && fast != null &&fast.next != null)
        {
            System.out.println(i++);
            if (slow.next == fast.next.next)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(fast != null &&fast.next != null)
        {
            System.out.println("iter: " + i++);
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return slow;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
        ListNode head = new ListNode(1);
        ListNode t = new ListNode(2);
        head.next = t;
        head.next.next = new ListNode(3);
        head.next.next.next = t;
//        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head).val);
    }

}
