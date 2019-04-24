/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (69.44%)
 * Total Accepted:    42.5K
 * Total Submissions: 61.1K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 *
 * A string S of lowercase letters is given.  We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 *
 *
 *
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 *
 */
class Solution {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c: S.toCharArray()) count[c-'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<MultiChar>((a, b) ->
            a.count == b.count ? a.letter - b.letter : b.count - a.count);

        for (int i = 0; i < 26; ++i) if (count[i] > 0) {
            if (count[i] > (N + 1) / 2) return "";
            pq.add(new MultiChar(count[i], (char) ('a' + i)));
        }

        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            ans.append(mc1.letter);
            ans.append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
            }
        }

        if (pq.size() > 0) ans.append(pq.poll().letter);
        return ans.toString();
    }
}
class MultiChar {
    int count;
    char letter;
    MultiChar(int ct, char ch) {
        count = ct;
        letter = ch;
    }
}

