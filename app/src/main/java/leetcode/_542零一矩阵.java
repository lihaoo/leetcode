package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _542零一矩阵 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return matrix;
        }
        int[][] seed = new int[matrix.length][matrix[0].length];
        List<Integer> list = new ArrayList();
        int column = matrix[0].length;
        int row = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i * column + j);
                    seed[i][j] = 1;
                }
            }
        }

        while (!list.isEmpty()) {
            int x = list.remove(0);
            int count = matrix[x / column][x % column];
            if (x % column + 1 < column && seed[x / column][x % column + 1] != 1) {
                matrix[x / column][x % column + 1] = count + 1;
                list.add(x + 1);
                seed[x / column][x % column + 1] = 1;
            }

            if (x % column - 1 >= 0 && seed[x / column][x % column - 1] != 1) {
                matrix[x / column][x % column - 1] = count + 1;
                list.add(x - 1);
                seed[x / column][x % column - 1] = 1;
            }

            if (x - column >= 0 && seed[x / column - 1][x % column] != 1) {
                matrix[x / column - 1][x % column] = count + 1;
                list.add(x - column);
                seed[x / column - 1][x % column] = 1;
            }

            if (x + column < row * column && seed[x / column + 1][x % column] != 1) {
                matrix[x / column + 1][x % column] = count + 1;
                list.add(x + column);
                seed[x / column + 1][x % column] = 1;
            }
        }
        return matrix;
    }
}
