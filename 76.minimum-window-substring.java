/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (30.15%)
 * Total Accepted:    219.7K
 * Total Submissions: 728.8K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 *
 * Note:
 *
 *
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 *
 */
import javafx.util.Pair;

class Solution {
    public String minWindow(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS == 0 || lenT == 0) return "";

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (char tc : t.toCharArray()) {
            int count = dictT.getOrDefault(tc, 0);
            dictT.put(tc, ++count);
        }
        int required = dictT.size();

        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < lenS; i++) {
            char sc = s.charAt(i);
            if (dictT.containsKey(sc)) filteredS.add(new Pair<Integer, Character>(i, sc));
        }

        int[] ans = {-1, 0, 0};
        int l = 0, r = 0, lenF = filteredS.size(), formed = 0;
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        while (r < lenF) {
            char c = filteredS.get(r).getValue();
            int wCount = window.getOrDefault(c, 0);
            window.put(c, ++wCount);

            if (dictT.containsKey(c) && window.get(c).intValue() == dictT.get(c).intValue()) ++formed;

            while (l <= r && formed == required) {
                char lc = filteredS.get(l).getValue();
                int start = filteredS.get(l).getKey();
                int end = filteredS.get(r).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[1] = start;
                    ans[2] = end;
                    ans[0] = end - start + 1;
                }
                window.put(lc, window.get(lc) - 1);
                if (dictT.containsKey(lc) && window.get(lc).intValue() < dictT.get(lc).intValue()) --formed;
                ++l;
            }
            ++r;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

