/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (59.66%)
 * Total Accepted:    57.5K
 * Total Submissions: 96.4K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 *
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature.  If there is no future day for which this is possible, put 0
 * instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76,
 * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 *
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 *
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len-1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return ans;
    }
}

