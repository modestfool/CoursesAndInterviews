import java.util.Scanner;
import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 1:32 PM.
 */
/*
    Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

 */
public class PalindromeLinkedList_234 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int v)
        {
            this.val = v;
        }
    }

    public static boolean isPalindromeStack(ListNode head)
    {
        if (head == null || head.next == null)
            return true;
        Stack <ListNode> rev = new Stack<>();
        ListNode temp = head;
        ListNode tail = head;
        while (tail != null)
        {
            rev.push(tail);
            tail = tail.next;
        }
        while (!rev.isEmpty() && temp != null)
        {
            tail = rev.pop();
            if (temp.val != tail.val)
                return false;
            temp = temp.next;
        }
        return true;
    }
    public static boolean isPalindrome(ListNode head)
    {
        if(head == null || head.next == null)
            return true;
        ListNode mid = head;
        ListNode end = head;
        while (end != null && end.next != null)
        {
            mid = mid.next;
            end = end.next.next;
        }
        mid = reverseLL(mid);
        while (mid != null && head!= null)
        {
            if (head.val != mid.val)
                return false;
            head = head.next;
            mid = mid.next;
        }
        return true;
    }

    private static ListNode reverseLL(ListNode head)
    {
        if (head == null)
            return head;
        ListNode prev = null;
        ListNode next = head;
        ListNode curr = head;
        while (curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
