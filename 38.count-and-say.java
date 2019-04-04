/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (39.84%)
 * Total Accepted:    268.7K
 * Total Submissions: 673.3K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 *
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the n^th term of the
 * count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 1
 * Output: "1"
 *
 *
 * Example 2:
 *
 *
 * Input: 4
 * Output: "1211"
 *
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder sb = new StringBuilder();

        String str = countAndSay(n-1);
        for (int i = 0, len = str.length(); i < len; i ++) {
            char c = str.charAt(i);
            int count = 1;
            while (i+1 < len && str.charAt(i+1) == c) {
                count ++;
                i ++;
            }
            sb.append(count + "" + c);
        }
        return sb.toString();
    }
}

