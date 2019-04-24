/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (41.31%)
 * Total Accepted:    200.1K
 * Total Submissions: 484.2K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 *
 *
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) num_set.add(num);

        int longest_steak = 0;
        for (int num : nums) {
            if (!num_set.contains(num-1)) {
                int curr_num = num;
                int curr_steak = 1;

                while (num_set.contains(curr_num+1)) {
                    curr_num += 1;
                    curr_steak += 1;
                }

                longest_steak = Math.max(longest_steak, curr_steak);
            }
        }
        return longest_steak;
    }
}

