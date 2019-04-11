/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.16%)
 * Total Accepted:    225.3K
 * Total Submissions: 744.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length, i = len-2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if (i >= 0) {
            int j = len-1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length-1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

