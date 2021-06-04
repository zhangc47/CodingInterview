package CodingInterview;


/**剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 *
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 */

public class Q04FindNumberIn2DArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // n * m
        int[][] matrix = new int[][] {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
                {20, 22, 24, 26, 28}
        };

        int target = 5;
        // int target = 20;

        System.out.println(solution.findNumberIn2DArray(matrix, target));
    }


    /**
     * 行和列都是递增的
     * 先确定在哪一列，然后再确定在这一行的具体位置
     * 有序，用二分查找
     * 找列的时候找比target小的最大的数字
     */
    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int row = matrix.length;
            int col = matrix[0].length;
            // 第一列
            int[] colArray = new int[row];
            for (int i = 0; i < row; i++) {
                colArray[i] = matrix[i][0];
            }


            int colIndex = binarySearch(colArray, target);

            return false;
        }

        /**二分查找
         *
         * @param nums
         * @param target
         * @return
         */
        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (target < nums[mid]) {
                    right = mid - 1;
                }
                else if (target > nums[mid]) {
                    left = mid + 1;
                }
                else {
                    return mid;
                }
            }


            return 0;
        }

    }


}



