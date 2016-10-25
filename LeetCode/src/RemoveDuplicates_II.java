/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 2:49 AM.
 */
public class RemoveDuplicates_II {
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        prev.next = head;
        ListNode curr = head;
        while(curr!= null)
        {
            while (curr!= null && curr.next != null && curr.val == curr.next.val)
            {
                curr = curr.next;
            }
            if (prev.next != curr)
                prev.next = curr.next;
            else
                prev = prev.next;
            curr = curr.next;
        }
        return newHead.next;
    }
}
