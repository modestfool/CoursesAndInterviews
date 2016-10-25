/**
 * @author: basavakanaparthi
 * on 22,Oct,2016 at 2:46 AM.
 */
public class LowestCommonAncestorBST {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { data = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
                                           TreeNode q)
    {
            if (root == null || p == null || q == null)
                return null;
            if (root == p || root == q)
                return root;
        System.out.println(root.data + " " + p.data + " " + q.data);
            int min = Math.min(p.data,q.data);

            int max = Math.max(p.data,q.data);
        System.out.println(max + ": " + min);
            if (root.data > min && root.data < max)
            {
                return root;
            }
            if (root.data < min)
                return lowestCommonAncestor(root.right,p,q);
            else
                return lowestCommonAncestor(root.left,p,q);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        right.left = new TreeNode(7);
        right.right = new TreeNode(9);
        root.right = right;
        System.out.println(lowestCommonAncestor(root,right.left,right.right).data);
    }
}
