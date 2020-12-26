package leetcode;

import java.util.ArrayList;

public class _695岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int i, int j) {
        int a = 0;
        int ROW = grid.length;
        int COL = grid[0].length;
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(j + i * COL);
        while (integers.size() > 0) {
            int temp = integers.remove(0);
            int x = temp % COL;
            int y = temp / COL;
            grid[y][x] = 2;
            a++;

            if ((x - 1) >= 0 && grid[y][x - 1] == 1 && !integers.contains((x - 1) + y * COL)) {
                integers.add((x - 1) + y * COL);
            }

            if ((x + 1) < COL && grid[y][x + 1] == 1 && !integers.contains((x + 1) + y * COL)) {
                integers.add((x + 1) + y * COL);
            }

            if ((y - 1) >= 0 && grid[y - 1][x] == 1 && !integers.contains(x + (y - 1) * COL)) {
                integers.add(x + (y - 1) * COL);
            }

            if ((y + 1) < ROW && grid[y + 1][x] == 1 && !integers.contains(x + (y + 1) * COL)) {
                integers.add(x + (y + 1) * COL);
            }
        }
        return a;
    }
}
