/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (42.44%)
 * Total Accepted:    37.7K
 * Total Submissions: 88.8K
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 *
 *
 * Example 1:
 *
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of
 * 0 and 1.
 *
 *
 *
 * Example 2:
 *
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
 *
 *
 *
 * Note:
 * The length of the given binary array will not exceed 50,000.
 *
 */

class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<IndexedWord>> groups = new HashMap();
        String[] ans = new String[words.size()];

        int index = 0;
        for (String word: words) {
            String ab = abbrev(word, 0);
            if (!groups.containsKey(ab))
                groups.put(ab, new ArrayList());
            groups.get(ab).add(new IndexedWord(word, index));
            index++;
        }

        for (List<IndexedWord> group: groups.values()) {
            Collections.sort(group, (a, b) -> a.word.compareTo(b.word));

            int[] lcp = new int[group.size()];
            for (int i = 1; i < group.size(); ++i) {
                int p = longestCommonPrefix(group.get(i-1).word, group.get(i).word);
                lcp[i] = p;
                lcp[i-1] = Math.max(lcp[i-1], p);
            }

            for (int i = 0; i < group.size(); ++i)
                ans[group.get(i).index] = abbrev(group.get(i).word, lcp[i]);
        }

        return Arrays.asList(ans);
    }

    public String abbrev(String word, int i) {
        int N = word.length();
        if (N - i <= 3) return word;
        return word.substring(0, i+1) + (N - i - 2) + word.charAt(N-1);
    }

    public int longestCommonPrefix(String word1, String word2) {
        int i = 0;
        while (i < word1.length() && i < word2.length()
                && word1.charAt(i) == word2.charAt(i))
            i++;
        return i;
    }
}

class IndexedWord {
    String word;
    int index;
    IndexedWord(String w, int i) {
        word = w;
        index = i;
    }
}

