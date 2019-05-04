/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (45.45%)
 * Total Accepted:    245.8K
 * Total Submissions: 539.4K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Example:
 *
 *
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 *
 *
 */
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;

        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);

        for (int row = 1; row < numRows; row++) {
            List<Integer> rowL = new ArrayList<Integer>();
            List<Integer> prevRow = triangle.get(row - 1);

            rowL.add(1);
            for (int j = 1; j < row; j++) rowL.add(prevRow.get(j-1) + prevRow.get(j));
            rowL.add(1);
            triangle.add(rowL);
        }

        return triangle;
    }
}

