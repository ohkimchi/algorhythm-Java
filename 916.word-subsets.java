/*
 * @lc app=leetcode id=916 lang=java
 *
 * [916] Word Subsets
 *
 * https://leetcode.com/problems/word-subsets/description/
 *
 * algorithms
 * Medium (44.44%)
 * Total Accepted:    9.2K
 * Total Submissions: 20.7K
 * Testcase Example:  '["amazon","apple","facebook","google","leetcode"]\n["e","o"]'
 *
 * We are given two arrays A and B of words.  Each word is a string of
 * lowercase letters.
 *
 * Now, say that word b is a subset of word a if every letter in b occurs in a,
 * including multiplicity.  For example, "wrr" is a subset of "warrior", but is
 * not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of
 * a. 
 *
 * Return a list of all universal words in A.  You can return the words in any
 * order.
 *
 *
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 *
 *
 *
 * Example 2:
 *
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 *
 *
 *
 * Example 3:
 *
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 *
 *
 *
 * Example 4:
 *
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B =
 * ["lo","eo"]
 * Output: ["google","leetcode"]
 *
 *
 *
 * Example 5:
 *
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B =
 * ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] and B[i] consist only of lowercase letters.
 * All words in A[i] are unique: there isn't i != j with A[i] == A[j].
 *
 *
 *
 *
 *
 *
 *
 */
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (int i = 0, len = B.length; i < len; i++) {
            int[] bCount = count(B[i]);
            for (int j = 0; j < 26; j++) {
                bmax[j] = Math.max(bmax[j], bCount[j]);
            }
        }
        List<String> res = new ArrayList();
        search: for (String a : A) {
            int[] aCount = count(a);
            for (int k = 0; k < 26; k++) {
                if (aCount[k] < bmax[k]) continue search;
            }
            res.add(a);
        }
        return res;
    }

    public int[] count(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) res[c - 'a']++;
        return res;
    }
}

