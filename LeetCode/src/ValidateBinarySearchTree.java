/**
 * @author: basavakanaparthi
 * on 17,Oct,2016 at 3:28 AM.
 */
/*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:
        2
       / \
      1   3
    Binary tree [2,1,3], return true.
    Example 2:
        1
       / \
      2   3
    Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree
{
    static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isValidBST(TreeNode root,
                              int min, int max)
    {
        if (root == null)
            return true;
        if(root.val > max || root.val < min)
            return false;
        else
            return isValidBST(root.left, min, root.val - 1) && isValidBST(root
                    .right, root.val + 1, max);

    }

}
