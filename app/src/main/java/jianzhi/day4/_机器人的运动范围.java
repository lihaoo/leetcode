package jianzhi.day4;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class _机器人的运动范围 {
    private int a = 0;
    private boolean[] visited;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        if (threshold == 0) {
            return 1;
        }

        visited = new boolean[rows * cols];

        return maxCount(threshold, rows, cols, 0, 0);
    }

    private int maxCount(int threshold, int rows, int cols, int row, int col) {
        if (row >= rows || col >= cols || row < 0 || col < 0) {
            return 0;
        }

        if (!allowIn(threshold, row, col)) {
            return 0;
        }

        if (visited[row * cols + col]) {
            return 0;
        }

        a++;
        visited[row * cols + col] = true;

        maxCount(threshold, rows, cols, row + 1, col);
        maxCount(threshold, rows, cols, row - 1, col);
        maxCount(threshold, rows, cols, row, col + 1);
        maxCount(threshold, rows, cols, row, col - 1);

        return a;
    }

    private boolean allowIn(int threshold, int row, int col) {
        if (row / 10 + row % 10 + col / 10 + col % 10 > threshold) {
            return false;
        }
        return true;
    }
}
