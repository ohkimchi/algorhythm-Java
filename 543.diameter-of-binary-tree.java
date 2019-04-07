/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (46.34%)
 * Total Accepted:    120.4K
 * Total Submissions: 259.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 *
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path
 * between any two nodes in a tree. This path may or may not pass through the
 * root.
 *
 *
 *
 * Example:
 * Given a binary tree
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \
 * ⁠     4   5
 *
 *
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 *
 * Note:
 * The length of path between two nodes is represented by the number of edges
 * between them.
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int longestPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getNodesNumInLongestRoute(root);
        return longestPath;
    }

    private int getNodesNumInLongestRoute(TreeNode node) {
        if (node == null) return 0;
        int l = getNodesNumInLongestRoute(node.left);
        int r = getNodesNumInLongestRoute(node.right);
        longestPath = Math.max(longestPath, l + r);
        return Math.max(l, r) + 1;
    }
}

