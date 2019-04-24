/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (49.46%)
 * Total Accepted:    71.3K
 * Total Submissions: 144.1K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1:
 *
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 *
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0, len = input.length(); i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for (int p1 : part1Res) {
                    for (int p2 : part2Res) {
                        int tmpRes = 0;
                        switch (c) {
                        case '+': tmpRes = p1 + p2;
                            break;
                        case '-': tmpRes = p1 - p2;
                            break;
                        case '*': tmpRes = p1 * p2;
                            break;
                        }
                        res.add(tmpRes);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}

