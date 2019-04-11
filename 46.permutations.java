/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.98%)
 * Total Accepted:    359K
 * Total Submissions: 661.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 *
 */
class Solution {
    public void backtrack(int len, List<Integer> l, List<List<Integer>> res, int first) {
        if (first == len) res.add(new ArrayList<Integer>(l));
        for (int i = first; i < len; i++) {
            Collections.swap(l, first, i);
            backtrack(len, l, res, first + 1);
            Collections.swap(l, i, first);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int n : nums) l.add(n);
        backtrack(len, l, res, 0);
        return res;
    }
}

