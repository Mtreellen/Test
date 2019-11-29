package array;

import java.util.Arrays;

/**
 * @author ellen
 * @date 2019-11-25 15:11
 * @description：LeetCode——867.转置矩阵
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        int[][] arr1 = transpose1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
    }

    /**
     * TODO：错误
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(i != j){
                    int tmp = A[i][j];
                    A[i][j] = A[j][j];
                    A[j][i] = tmp;
                }
            }
        }
        return A;
    }
    public static int[][] transpose1(int[][] A) {
        int[][] arr = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length ; j++) {
                arr[i][j] = A[j][i];
            }
        }
        return arr;
    }

}
