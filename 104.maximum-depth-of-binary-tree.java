/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (59.63%)
 * Total Accepted:    479.8K
 * Total Submissions: 802K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * return its depth = 3.
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
import javafx.util.Pair;

class Solution {
    public int maxDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) stack.push(new Pair<TreeNode, Integer>(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.pollLast();
            TreeNode r = curr.getKey();
            int r_depth = curr.getValue();
            if (r != null) {
                depth = Math.max(depth, r_depth);
                stack.push(new Pair<TreeNode, Integer>(r.left, depth + 1));
                stack.push(new Pair<TreeNode, Integer>(r.right, depth + 1));
            }
        }
        return depth;
    }
}

