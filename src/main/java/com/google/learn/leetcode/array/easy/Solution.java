package com.google.learn.leetcode.array.easy;

import java.util.Arrays;

public class Solution {

    /**
     * 输入: [[1,1,0],[1,0,1],[0,0,0]]
     * 输出: [[1,0,0],[0,1,0],[1,1,1]]
     * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flipping-an-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int temp = 0;
        int rowSize = A.length;
        for (int row = 0; row < rowSize; row++) {
            int columnSize = A[row].length;
            for (int column = 0; column < columnSize / 2.; column++) {
                A[row][column] = (A[row][column] + 1) % 2;
                A[row][columnSize - 1 - column] = (A[row][columnSize - 1 - column] + 1) % 2;
                temp = A[row][column];
                A[row][column] = A[row][columnSize - 1 - column];
                A[row][columnSize - 1 - column] = temp;
            }
            if (columnSize % 2 != 0) {
                A[row][(int) ((columnSize) / 2. - 0.5)] = (A[row][(int) ((columnSize) / 2. - 0.5)] + 1) % 2;
            }
        }
        return A;
    }


    public static int[] sortedSquares(int[] A) {
        int[] result = A;
        for (int column = 0; column < result.length; column++) {
            result[column] = result[column] * result[column];
        }
        Arrays.sort(result);
        return result;
    }

}
