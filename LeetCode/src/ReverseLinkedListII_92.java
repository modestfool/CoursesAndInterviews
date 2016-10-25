import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 04,Oct,2016 at 11:09 PM.
 */
/*

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
public class ReverseLinkedListII_92 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseK(ListNode head, int k)
    {
        if (head == null || k == 0)
            return head;
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = head;
        int t = k;
        while (k > 0 && curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
//        if (size(next) >= t)
            head.next = reverseK(next,t);
//        else
//            head.next = next;
        return prev;
    }

    public static int size(ListNode head)
    {
        if (head == null)
            return 0;
        ListNode temp = head;
        int size = 0;
        while (temp != null)
        {
            temp = temp.next;
            size++;
        }
        System.out.println(size);
        return size;
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) 
            return head;
        ListNode start = head;
        ListNode prev = null;
        for (int i = 1; i < m && start!= null; i++)
        {
            prev = start;
            start = start.next;
        }
//        printLL(start.next);
        start = reverseBetween(start, n-m +1);
        if (prev == null)
            return start;
        prev.next = start;
        return head;
    }

    public static ListNode reverseBetween(ListNode start, int i) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = start;
        while (i > 0 && curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i--;
        }
//        printLL(end);
        start.next = next;
//        printLL(prev);
        return prev;
    }
    public static void printLL(ListNode head)
    {
        while (head!= null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for(int i = 2; i < 9; i++)
        {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        printLL(head);
        printLL(reverseBetween(head,1,2));
//        printLL(reverseK(head,3));
    }

}
