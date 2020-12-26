package jianzhi.day5;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return integers;
        }

        int rows = matrix.length;
        int lows = matrix[0].length;

        int startX = 0, startY = 0;
        int endX = lows - 1, endY = rows - 1;

        while (startX < endX || startY < endY) {

            for (int i = startX; i <= endX; i++) {
                integers.add(matrix[startX][i]);
            }

            for (int i = startY; i <= endY; i++) {
                integers.add(matrix[i][endY]);
            }

            for (int i = endX; i <= startX; i--) {
                integers.add(matrix[endY][i]);
            }

            for (int i = endY; i <= startY; i--) {
                integers.add(matrix[i][startX]);
            }

            startX++;
            startY++;
            endX--;
            endY--;
        }

        if (startX == endX && startY == endY) {
            integers.add(matrix[startY][startX]);
        }

        return integers;

    }
}
