/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 *
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (41.59%)
 * Total Accepted:    24.2K
 * Total Submissions: 58.1K
 * Testcase Example:  '"aab"'
 *
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty
 * string.
 *
 * Example 1:
 *
 *
 * Input: S = "aab"
 * Output: "aba"
 *
 *
 * Example 2:
 *
 *
 * Input: S = "aaab"
 * Output: ""
 *
 *
 * Note:
 *
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 *
 *
 *
 *
 */
class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) count[c-'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<>((a, b) ->
                a.count == b.count ? a.letter-b.letter : b.count-a.count);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > (len+1)/2) return "";
                pq.add(new MultiChar(count[i], (char)('a'+i)));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll(), mc2 = pq.poll();
            ans.append(mc1.letter);
            ans.append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
        }
        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }

    class MultiChar {
        int count;
        char letter;
        MultiChar(int cnt, char ch) {
            count = cnt;
            letter = ch;
        }
    }
}

