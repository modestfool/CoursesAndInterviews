/**
 * @author: basavakanaparthi
 * on 11,Oct,2016 at 3:34 PM.
 */
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.


 */
public class RemoveDuplicatesSortedList
{
    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        while (temp!= null && temp.next != null)
        {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                continue;
            }
            printLL(head);
            temp = temp.next;
        }
        //if (temp != null )

        return head;
    }
    static void printLL(ListNode head)
    {
        ListNode temp = head;
        while (temp.next!= null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(3);
        printLL(head);
        head = deleteDuplicates(head);
        printLL(head);
    }
}
