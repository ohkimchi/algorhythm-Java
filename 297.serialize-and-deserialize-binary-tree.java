/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (40.18%)
 * Total Accepted:    173.2K
 * Total Submissions: 430.8K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * Example: 
 *
 *
 * You may serialize the following tree:
 *
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 *
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
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
public class Codec {
    public String rSerialize(TreeNode node, String str) {
        if (node == null) str += "null,";
        else {
            str += str.valueOf(node.val) + ",";
            str = rSerialize(node.left, str);
            str = rSerialize(node.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public TreeNode rDeserialize(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = rDeserialize(l);
        node.right = rDeserialize(l);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_arr));
        return rDeserialize(data_list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

