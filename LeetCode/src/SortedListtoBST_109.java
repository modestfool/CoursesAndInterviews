import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 19,Oct,2016 at 8:33 AM.
 */
/*
    https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

    Given a singly
    linked list where elements are sorted in ascending order,
     convert it to a height balanced BST.
 */

public class SortedListtoBST_109 {
    public static TreeNode sortedListToBST(ListNode
                                                                          head) {
        if (head == null)
            return null;
        ListNode prev;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow.next = null;
        TreeNode root = new TreeNode(prev.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(prev.next);
        return root;
    }

    static void inOrder(TreeNode root) {
        if(root == null) {
            System.out.println("null");
            return;
        }

        if(root.left != null)
            inOrder(root.left);

        System.out.print(root.val + " ");

        if(root.right != null)
            inOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        ListNode head = new ListNode(in.nextInt());
        ListNode tmp = head;
        while (len - 1 > 0) {
            tmp.next = new ListNode(in.nextInt());
            tmp = tmp.next;
            len--;
        }
        inOrder(sortedListToBST(head));
    }
}
