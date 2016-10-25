/**
 * @author: basavakanaparthi
 * on 27,Sep,2016 at 1:06 AM.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *  95. Unique Binary Search Trees II
     Total Accepted: 65585
     Total Submissions: 219125
     Difficulty: Medium
         Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

         For example,
         Given n = 3, your program should return all 5 unique BST's shown below.

         1         3     3      2      1
         \       /     /      / \      \
         3     2     1      1   3      2
         /     /       \                 \
         2     1         2                 3
 */

public class UniqueBinarySearchTreesII_95
{
    public static List<TreeNode> generateTrees(int n)
    {
        return generateTreeNodes(1,n);
    }
    public static List<TreeNode> generateTreeNodes(int start, int end)
    {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end)
        {
            nodes.add(null);
            return nodes;
        }
        System.out.println(start + ": " + end );
        for (int i = start; i <=end; i++) {
            List<TreeNode> leftSubTree = generateTreeNodes(start, i - 1);
            List<TreeNode> rightSubTree = generateTreeNodes(i + 1, end);
            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    TreeNode root = new TreeNode(i);
                    System.out.println(start + ": " + end );
                    TreeNode.inOrder(left);
                    TreeNode.inOrder(root);
                    TreeNode.inOrder(right);
                    System.out.println();
                    root.left = left;
                    root.right = right;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<TreeNode> BSTs = generateTrees(in.nextInt());

        for(TreeNode node: BSTs) {
            TreeNode.inOrder(node);
            System.out.println();
        }
    }
}
