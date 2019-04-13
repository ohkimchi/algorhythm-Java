/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (45.15%)
 * Total Accepted:    57.1K
 * Total Submissions: 126.2K
 * Testcase Example:  '"abcdefg"\n2'
 *
 *
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 *
 *
 * Example:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 *
 *
 * Restrictions:
 *
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 *
 */
class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int start = 0, len = c.length; start < len; start += 2*k) {
            int i = start, j = Math.min(start+k-1, len-1);
            while (i < j) {
                char temp = c[i];
                c[i++] = c[j];
                c[j--] = temp;
            }
        }
        return new String(c);
    }
}

