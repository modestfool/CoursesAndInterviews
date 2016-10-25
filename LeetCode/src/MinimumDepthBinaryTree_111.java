/**
 * @author: basavakanaparthi
 * on 17,Oct,2016 at 9:23 PM.
 */
/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path
    from the root node down to the nearest leaf node.
 */
public class MinimumDepthBinaryTree_111
{
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int minDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left != null && root.right != null)
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        else if (root.right != null)
            return minDepth(root.right) + 1;
        else
            return minDepth(root.left) + 1;

    }
    public static int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
            return Math.max(minDepth(root.left),minDepth(root.right)) + 1;

    }

    public static void main(String[] args) {
        Integer[] treeNodes = {3,9,20,null,null,15,7};
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        System.out.println(minDepth(root));
    }
}
