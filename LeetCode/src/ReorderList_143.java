import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 08,Oct,2016 at 1:23 AM.
 */
/*
    https://leetcode.com/problems/reorder-list/

    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList_143
{
    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }

    public static void reorderList(ListNode head)
    {
        if (head == null)
            return;
        ListNode fast = head;
        ListNode mid = head;
        ListNode tmp = head;
        while(fast != null && fast.next != null)
        {
            mid = mid.next;
            fast = fast.next.next;
        }
        tmp = mid.next;
        mid.next = null;
        mid = reverseList(tmp);
        ListNode cur1 = head;
        ListNode cur2 = mid;
        ListNode tmp1, tmp2;
        while (cur1 != null && cur2 != null)
        {
            tmp1 = cur1.next;
            tmp2 = cur2.next;
            cur1.next = cur2;
            cur2.next = tmp1;
            cur1 = tmp1;
            cur2 = tmp2;
        }
    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode next, prev = null, curr = head;
        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
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

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
       int len = in.nextInt();
        ListNode head = new ListNode(in.nextInt());
        ListNode tmp = head;
        while (len-1 > 0){
            tmp.next = new ListNode(in.nextInt());
            tmp = tmp.next;
            len --;
        }
        printLL(head);
        reorderList(head);
        printLL(head);
    }
}
