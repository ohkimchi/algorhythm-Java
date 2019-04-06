/*
 * @lc app=leetcode id=709 lang=java
 *
 * [709] To Lower Case
 *
 * https://leetcode.com/problems/to-lower-case/description/
 *
 * algorithms
 * Easy (76.39%)
 * Total Accepted:    89.9K
 * Total Submissions: 117.7K
 * Testcase Example:  '"Hello"'
 *
 * Implement function ToLowerCase() that has a string parameter str, and
 * returns the same string in lowercase.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "Hello"
 * Output: "hello"
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "here"
 * Output: "here"
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "LOVELY"
 * Output: "lovely"
 *
 *
 *
 *
 *
 */
class Solution {
    public String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0, len = ch.length; i < len; i++) {
            char c = ch[i];
            if ('A' <= c && 'Z' >= c)
                ch[i] = (char)(c - 'A' + 'a');
        }
        return new String(ch);
    }
}

