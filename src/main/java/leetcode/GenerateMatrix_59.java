package leetcode;

public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int max = n * n;
        int i = 1;
        int row = 0, col = 0;
        res[row][col] = i++;
        while (i <= max) {
            while (++col < n && res[row][col] == 0) {
                res[row][col] = i++;
            }
            --col;
            while (++row < n && res[row][col] == 0) {
                res[row][col] = i++;
            }
            --row;
            while (--col >= 0 && res[row][col] == 0) {
                res[row][col] = i++;
            }
            ++col;
            while (--row >= 0 && res[row][col] == 0) {
                res[row][col] = i++;
            }
            ++row;
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix_59 generateMatrix_59 = new GenerateMatrix_59();
        LeetCodeUtils.print2DArray(generateMatrix_59.generateMatrix(4));

    }
}
