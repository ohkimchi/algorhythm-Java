/*
 * @lc app=leetcode id=675 lang=java
 *
 * [675] Cut Off Trees for Golf Event
 *
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
 *
 * algorithms
 * Hard (30.37%)
 * Total Accepted:    14.4K
 * Total Submissions: 47.3K
 * Testcase Example:  '[[1,2,3],[0,0,4],[7,6,5]]'
 *
 * You are asked to cut off trees in a forest for a golf event. The forest is
 * represented as a non-negative 2D map, in this map:
 *
 *
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through,
 * and this positive number represents the tree's height.
 *
 *
 *
 *
 * You are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after
 * cutting, the original place has the tree will become a grass (value 1).
 *
 * You will start from the point (0, 0) and you should output the minimum steps
 * you need to walk to cut off all the trees. If you can't cut off all the
 * trees, output -1 in that situation.
 *
 * You are guaranteed that no two trees have the same height and there is at
 * least one tree needs to be cut off.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * ⁠[1,2,3],
 * ⁠[0,0,4],
 * ⁠[7,6,5]
 * ]
 * Output: 6
 *
 *
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [
 * ⁠[1,2,3],
 * ⁠[0,0,0],
 * ⁠[7,6,5]
 * ]
 * Output: -1
 *
 *
 *
 *
 * Example 3:
 *
 *
 * Input:
 * [
 * ⁠[2,3,4],
 * ⁠[0,0,5],
 * ⁠[8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree
 * in (0,0) directly without walking.
 *
 *
 *
 *
 * Hint: size of the given matrix will not exceed 50x50.
 *
 */
import java.util.LinkedList;

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        int rowN = forest.size(), colN = forest.get(0).size();
        List<int[]> trees = new ArrayList();
        for (int r = 0; r < rowN; r++) {
            for (int c = 0; c < colN; c++) {
                int n = forest.get(r).get(c);
                if (n > 0) trees.add(new int[]{n, r, c});
            }
        }

        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int sourceRow = 0, sourceCol = 0, ans = 0;
        for (int[] t : trees) {
            int d = bsf(forest, sourceRow, sourceCol, t[1], t[2]);
            if (d < 0) return -1;
            ans += d;
            sourceRow = t[1];
            sourceCol = t[2];
        }
        return ans;
    }

    public int bsf(List<List<Integer>> forest, int sourceRow, int sourceCol, int targetRow, int targetCol) {
        int rowN = forest.size(), colN = forest.get(0).size();
        boolean[][] visited = new boolean[rowN][colN];
        visited[sourceRow][sourceCol] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sourceRow, sourceCol, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == targetRow && curr[1] == targetCol) return curr[2];
            for (int[] dir : dirs) {
                int currRow = curr[0] + dir[0], currCol = curr[1] + dir[1];
                if (0 <= currRow && currRow < rowN && 0 <= currCol && currCol < colN &&
                        !visited[currRow][currCol] && forest.get(currRow).get(currCol) > 0) {
                    visited[currRow][currCol] = true;
                    queue.add(new int[]{currRow, currCol, curr[2]+1});
                }
            }
        }
        return -1;
    }
}

