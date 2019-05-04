/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Medium (63.25%)
 * Total Accepted:    48.4K
 * Total Submissions: 76.7K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * We have a list of points on the plane.  Find the K closest points to the
 * origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean
 * distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be
 * unique (except for the order that it is in.)
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just
 * [[-2,2]].
 *
 *
 *
 * Example 2:
 *
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 *
 *
 */
import java.util.concurrent.ThreadLocalRandom;

class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        sort(0, points.length-1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void sort(int i, int j, int K) {
        if (i >= j) return;
        int k = ThreadLocalRandom.current().nextInt(i, j);
        swap(i, k);
        int mid = partition(i, j);
        int leftLength = mid - i + 1;
        if (K < leftLength) sort(i, mid-1, K);
        else if (K > leftLength) sort(mid+1, j, K-leftLength);
    }

    public void swap(int i, int k) {
        int k0 = points[k][0], k1 = points[k][1];
        points[k][0] = points[i][0];
        points[k][1] = points[i][1];
        points[i][0] = k0;
        points[i][1] = k1;
    }

    public int partition(int i, int j) {
        int oi = i;
        int pivot = dist(i);
        i++;
        while (true) {
            while (i < j && dist(i) <= pivot) i++;
            while (i <= j && dist(j) >= pivot) j--;
            if (i >= j) break;
            swap(i, j);
        }
        swap(oi, j);
        return j;
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
}

