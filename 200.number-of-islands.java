/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (40.70%)
 * Total Accepted:    328.5K
 * Total Submissions: 803.3K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 *
 * Example 1:
 *
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;

        int row = grid.length, col = grid[0].length, res = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if ('1' == grid[r][c]) {
                    grid[r][c] = 0;
                    ++res;
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(r * col + c);
                    while (!neighbours.isEmpty()) {
                        int id = neighbours.remove();
                        int ri = id / col, ci = id % col;
                        if (ri - 1 >= 0 && '1' == grid[ri-1][ci]) {
                            neighbours.add((ri-1)*col + ci);
                            grid[ri-1][ci] = '0';
                        }
                        if (ri + 1 < row && '1' == grid[ri+1][ci]) {
                            neighbours.add((ri+1)*col + ci);
                            grid[ri+1][ci] = '0';
                        }
                        if (ci - 1 >= 0 && '1' == grid[ri][ci-1]) {
                            neighbours.add(ri*col + (ci-1));
                            grid[ri][ci-1] = '0';
                        }
                        if (ci + 1 < col && '1' == grid[ri][ci+1]) {
                            neighbours.add(ri*col + (ci+1));
                            grid[ri][ci+1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}

