/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (44.14%)
 * Total Accepted:    93.7K
 * Total Submissions: 211.6K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 *
 * Given an encoded string, return it's decoded string.
 *
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 *
 *
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 *
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 *
 */
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        char[] ch = s.toCharArray();
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> res = new Stack<>();
        res.push(new StringBuilder());

        int num = 0;
        for (char c : ch) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                res.add(new StringBuilder());
                count.push(num);
                num = 0;
            } else if (c == ']') {
                String repeatedStr = res.pop().toString();
                StringBuilder decodePart = new StringBuilder();
                for (int i = 0, len = count.pop(); i < len; i++) {
                    decodePart.append(repeatedStr);
                }
                res.push(res.pop().append(decodePart.toString()));
            } else {
                res.peek().append(c);
            }
        }
        return res.pop().toString();
    }
}

