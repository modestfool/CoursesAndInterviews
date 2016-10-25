/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 1:16 PM.
 */
/*
    https://leetcode.com/problems/symmetric-tree/
    Given a binary tree, check whether it is a mirror of itself
        (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
       \   \
       3    3
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root)
    {
        return root==null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
