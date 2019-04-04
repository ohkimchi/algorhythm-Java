/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.79%)
 * Total Accepted:    61.5K
 * Total Submissions: 206.3K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 *
 *
 *
 * Note:
 *
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means .
 *
 *
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE,
            len = nums.length, l, r;
        boolean flag = false;
        for (int i = 1; i < len; i ++) {
            if (nums[i-1] > nums[i]) flag = true;
            if (flag) min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int j = len - 2; j >= 0 ; j --) {
            if (nums[j+1] < nums[j]) flag = true;
            if (flag) max = Math.max(max, nums[j]);
        }
        for (l = 0; l < len; l ++) {
            if (min < nums[l])  break;
        }
        for (r = len - 1; r >= 0; r --) {
            if (max > nums[r]) break;
        }

        return r < l ? 0 : r - l + 1;
    }
}

