/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.72%)
 * Total Accepted:    387K
 * Total Submissions: 1.2M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
class Solution {
    int [] nums;
    int target;

    public int find_rotate_index(int left, int right) {
      if (nums[left] < nums[right])
        return 0;

      while (left <= right) {
        int pivot = (left + right) / 2;
        if (nums[pivot] > nums[pivot + 1])
          return pivot + 1;
        else {
          if (nums[pivot] < nums[left])
            right = pivot - 1;
          else
            left = pivot + 1;
        }
      }
      return 0;
    }

    public int search(int left, int right) {
      while (left <= right) {
        int pivot = (left + right) / 2;
        if (nums[pivot] == target)
          return pivot;
        else {
          if (target < nums[pivot])
            right = pivot - 1;
          else
            left = pivot + 1;
        }
      }
      return -1;
    }

    public int search(int[] nums, int target) {
      this.nums = nums;
      this.target = target;

      int n = nums.length;

      if (n == 0)
        return -1;
      if (n == 1)
        return this.nums[0] == target ? 0 : -1;

      int rotate_index = find_rotate_index(0, n - 1);

      if (nums[rotate_index] == target)
        return rotate_index;
      if (rotate_index == 0)
        return search(0, n - 1);
      if (target < nums[0])
        return search(rotate_index, n - 1);
      return search(0, rotate_index);
    }
  }

