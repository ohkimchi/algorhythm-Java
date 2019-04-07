/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (30.53%)
 * Total Accepted:    165K
 * Total Submissions: 538.8K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 *
 *
 *
 *
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 *
 *
 *
 * Example:
 *
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 *
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int len = heights.length, max = 0;
        for (int i = 0; i < len; i++) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i])
                max = Math.max(max, heights[st.pop()] * (i - st.peek() - 1));
            st.push(i);
        }
        while (st.peek() != -1)
            max = Math.max(max, heights[st.pop()] * (len - st.peek() - 1));

            return max;
    }
}


