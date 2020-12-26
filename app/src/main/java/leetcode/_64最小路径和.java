package leetcode;

public class _64最小路径和 {

    private int[][] gridMin;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        gridMin = new int[row][col];
        gridMin[0][0] = grid[0][0];

        for (int i = 0; i < col; i++) {
            int temp;
            for (int j = 0; j < row; j++) {
                if(i == 0 && j == 0){
                    continue;
                }
//                if (i == 0) {
//                    temp = getValue(i, j);
//                    gridMin[0][j] = temp + getMin(i, j - 1);
//                } else {
                if (getMin(i, j - 1) < getMin(i - 1, j)) {
                    gridMin[i][j] = getMin(i, j - 1) + grid[i][j];
                } else {
                    gridMin[i][j] = getMin(i - 1, j) + grid[i][j];

                }
//                }
            }
        }

        return gridMin[row - 1][col - 1];
    }

    private int getMin(int row, int col) {
        if (row < 0) {
            return Integer.MAX_VALUE;
        }
        if (col < 0) {
            return Integer.MAX_VALUE;
        }
        return gridMin[row][col];
    }
}
