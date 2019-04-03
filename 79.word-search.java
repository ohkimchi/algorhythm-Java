/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.65%)
 * Total Accepted:    263.5K
 * Total Submissions: 857.7K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 *
 * Example:
 *
 *
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
                if (exist(board, row, col, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, char[] word, int i) {
        if (i == word.length) return true;
        if (row<0 || col<0 || row == board.length || col == board[row].length) return false;
        if (board[row][col] != word[i]) return false;
        board[row][col] ^= 256;
        boolean exist = exist(board, row, col+1, word, i+1)
            || exist(board, row, col-1, word, i+1)
            || exist(board, row+1, col, word, i+1)
            || exist(board, row-1, col, word, i+1);
        board[row][col] ^= 256;
        return exist;
    }
}

