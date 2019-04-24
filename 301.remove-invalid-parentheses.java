/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (38.87%)
 * Total Accepted:    117.7K
 * Total Submissions: 302.5K
 * Testcase Example:  '"()())()"'
 *
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 *
 * Example 1:
 *
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 *
 * Example 2:
 *
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 *
 * Example 3:
 *
 *
 * Input: ")("
 * Output: [""]
 *
 */
class Solution {
    private Set<String> validExpressions = new HashSet<>();

    private void recurse(
            String s,
            int index,
            int leftCount,
            int rightCount,
            int leftRem,
            int rightRem,
            StringBuilder expression) {

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) this.validExpressions.add(expression.toString());
        } else {
            char ch = s.charAt(index);
            int len = expression.length();
            if ((ch == '(' && leftRem > 0) || ch == ')' && rightRem > 0)
                this.recurse(
                        s,
                        index+1,
                        leftCount,
                        rightCount,
                        leftRem - (ch == '(' ? 1 : 0),
                        rightRem - (ch == ')' ? 1 : 0),
                        expression);
            expression.append(ch);

            if (ch != '(' && ch != ')') {
                this.recurse(s, index+1, leftCount, rightCount, leftRem, rightRem, expression);
            } else if (ch == '(') {
                this.recurse(s, index+1, leftCount+1, rightCount, leftRem, rightRem, expression);
            } else if (rightCount < leftCount) {
                this.recurse(s, index+1, leftCount, rightCount+1, leftRem, rightRem, expression);
            }

            expression.deleteCharAt(len);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(') left++;
            else if (s.charAt(i) == ')') {
                right = left == 0 ? right+1 : right;
                left = left > 0 ? left-1 : left;
            }
        }
        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<String>(this.validExpressions);
    }
}

