/**
 * @author: basavakanaparthi
 * on 22,Oct,2016 at 7:45 PM.
 */
/*
    Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can’t invert a binary tree on a whiteboard so fuck off.

 */
public class InvertBinaryTree
{
    public TreeNode invertTree(TreeNode root)
    {
        if (root == null)
            return null;
        TreeNode lInvert = invertTree(root.left);
        TreeNode rInvert = invertTree(root.right);
        root.left = rInvert;
        root.right = lInvert;
        return root;
    }
}
