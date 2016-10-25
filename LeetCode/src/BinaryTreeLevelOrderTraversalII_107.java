import java.util.*;

/**
 * @author: basavakanaparthi
 * on 17,Oct,2016 at 9:04 PM.
 */
/*
    Given a binary tree, return the bottom-up level order traversal
     of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]

 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

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
    static void preOrder(TreeNode root) {
        if(root == null) {
            System.out.println("null");
            return;
        }

        System.out.print(root.val + " ");

        if(root.left != null)
            inOrder(root.left);

        if(root.right != null)
            inOrder(root.right);
    }
}
public class BinaryTreeLevelOrderTraversalII_107
{
    public static List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<List<Integer>> resStack = new Stack<>();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty())
        {
            TreeNode curr = treeQueue.poll();
            List<TreeNode> successors = new ArrayList<>();
            List<Integer> currLevel = new ArrayList<>();
            if(curr.left != null)
                successors.add(curr.left);
            if(curr.right != null)
                successors.add(curr.right);
            currLevel.add(curr.val);

            while(!treeQueue.isEmpty())
            {
                curr = treeQueue.poll();
                currLevel.add(curr.val);
                if(curr.left != null)
                    successors.add(curr.left);
                if(curr.right != null)
                    successors.add(curr.right);
            }
            resStack.push(currLevel);
            treeQueue.addAll(successors);
        }
        while (!resStack.isEmpty())
            res.add(resStack.pop());
        return res;
    }

    public static void main(String[] args) {
        Integer[] treeNodes = {3,9,20,null,null,15,7};
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        System.out.println(levelOrderBottom(root));
    }
}
