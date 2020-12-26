package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _994腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return -1;
        }

        int mins = 0;
        List<Orange> oranges = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    oranges.add(new Orange(j, i));
                }
            }
        }

        while (oranges.size() > 0) {
            while (oranges.size() > 0 && grid[oranges.get(0).y][oranges.get(0).x] == 2) {
                Orange orange = oranges.remove(0);
                if (orange.x - 1 >= 0 && grid[orange.y][orange.x - 1] == 1) {
                    Orange orange1 = new Orange(orange.x - 1, orange.y);
                    if (!oranges.contains(orange1)) {
                        oranges.add(orange1);
                    }
                }

                if (orange.x + 1 < grid[0].length && grid[orange.y][orange.x + 1] == 1) {
                    Orange orange1 = new Orange(orange.x + 1, orange.y);
                    if (!oranges.contains(orange1)) {
                        oranges.add(orange1);
                    }
                }

                if (orange.y - 1 >= 0 && grid[orange.y - 1][orange.x] == 1) {
                    Orange orange1 = new Orange(orange.x, orange.y - 1);
                    if (!oranges.contains(orange1)) {
                        oranges.add(orange1);
                    }
                }

                if (orange.y + 1 < grid.length && grid[orange.y + 1][orange.x] == 1) {
                    Orange orange1 = new Orange(orange.x, orange.y + 1);
                    if (!oranges.contains(orange1)) {
                        oranges.add(orange1);
                    }
                }
            }
            mins++;
            for (int i = 0; i < oranges.size(); i++) {
                grid[oranges.get(i).y][oranges.get(i).x] = 2;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return mins-1;
    }

    private class Orange {

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }
}
