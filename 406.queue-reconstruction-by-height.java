/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (59.37%)
 * Total Accepted:    75.1K
 * Total Submissions: 126.5K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[list.size()][]);
    }
}

