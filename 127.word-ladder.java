/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (23.61%)
 * Total Accepted:    251.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 *
 *
 * Note:
 *
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 *
 *
 *
 *
 *
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();

        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, len);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        Queue<HashMap<String, Integer>> q = new LinkedList<HashMap<String, Integer>>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        q.add(map);

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            Map<String, Integer> node = q.remove();
            Map.Entry<String, Integer> entry = node.entrySet().iterator().next();
            String word = entry.getKey();
            int level = node.get(word);

            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, len);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (adjacentWord.equals(endWord)) return level + 1;
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        HashMap<String, Integer> newMap = new HashMap<>();
                        newMap.put(adjacentWord, level + 1);
                        q.add(newMap);
                    }
                }
            }
        }

        return 0;
    }
}

