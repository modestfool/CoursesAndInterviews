/**
 * @author: basavakanaparthi
 * on 22,Oct,2016 at 4:10 AM.
 */
/*
    Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.


 */
public class MergeTwoSortedLists_21
{
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while(l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                temp.next = l1;
                l1 = l1.next;
            }
            else
            {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null)
            temp.next = l1;
        else if (l2 != null)
            temp.next = l2;
        return newHead.next;
    }
}
