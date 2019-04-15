/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (40.30%)
 * Total Accepted:    212.6K
 * Total Submissions: 527K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    int[] preorder, inorder;
    int pre_idx = 0;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int left, int right) {
        if (left == right) return null;
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int idx = idx_map.get(root_val);
        pre_idx++;
        root.left = helper(left, idx);
        root.right = helper(idx+1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for (int val : inorder) idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }
}
