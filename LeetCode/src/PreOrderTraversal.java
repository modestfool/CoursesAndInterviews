import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 17,Oct,2016 at 5:26 AM.
 */
/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root)
    {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> preOrderStack = new Stack<>();
        if (root == null)
            return result;
        preOrderStack.push(root);
        while(!preOrderStack.isEmpty())
        {
            TreeNode current = preOrderStack.pop();
            result.add(current.val);
            if(current.right != null)
                preOrderStack.push(current.right);
            if(current.left != null)
                preOrderStack.push(current.left);
        }
        return result;
    }
}
