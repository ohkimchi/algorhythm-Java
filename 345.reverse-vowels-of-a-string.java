/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (41.02%)
 * Total Accepted:    146.8K
 * Total Submissions: 357.9K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 *
 * Example 1:
 *
 *
 * Input: "hello"
 * Output: "holle"
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "leetcode"
 * Output: "leotcede"
 *
 *
 * Note:
 * The vowels does not include the letter "y".
 *
 *
 *
 */
class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] sc = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(sc[start] + "")) start++;
            while (start < end && !vowels.contains(sc[end] + "")) end--;
            char temp = sc[start];
            sc[start] = sc[end];
            sc[end] = temp;
            start++;
            end--;
        }
        return new String(sc);
    }
}

