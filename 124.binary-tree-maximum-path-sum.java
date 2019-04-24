/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (29.68%)
 * Total Accepted:    182.7K
 * Total Submissions: 615.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 *
 * Example 1:
 *
 *
 * Input: [1,2,3]
 *
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 *
 * Output: 6
 *
 *
 * Example 2:
 *
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * Output: 42
 *
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
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;
        int left_path = Math.max(max_gain(node.left), 0);
        int right_path = Math.max(max_gain(node.right), 0);
        int new_path_sum = left_path + node.val + right_path;
        max_sum = Math.max(new_path_sum, max_sum);
        return node.val + Math.max(left_path, right_path);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}

