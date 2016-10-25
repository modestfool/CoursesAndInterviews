import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 22,Oct,2016 at 3:38 AM.
 */
/*
    Write a function to delete a node (except the tail) in a singly linked list,
    given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
with value 3, the linked list should become 1 -> 2 -> 4 after calling your
function.
 */

/*
    Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

 */
public class DeleteNodeinLinkedList_237 {
    public void deleteNode(ListNode node)
    {
        if (node.next == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static ListNode removeElements(ListNode head, int val)
    {
        if (head == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            if (curr.val == val)
            {
                if(prev == null) {
                    head = head.next;
                }
                else
                {
                    prev.next = curr.next;
                }
            }
            else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode.printLL(head);
        head = removeElements(head,3);
        ListNode.printLL(head);
    }
}
