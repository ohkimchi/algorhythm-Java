/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (41.83%)
 * Total Accepted:    90.5K
 * Total Submissions: 216K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 *
 * Note:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 *
 *
 *
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0, len = nums.length; start < len; start++) {
            int sum = 0;
            for (int end = start; end < len; end++) {
                sum += nums[end];
                if (sum == k) ++count;
            }
        }
        return count;
    }
}

