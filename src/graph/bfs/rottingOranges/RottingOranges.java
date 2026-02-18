package graph.bfs.rottingOranges;

import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {

        int[][] grid1 = {
                {1,1,0},
                {0,1,1},
                {0,1,2}
        };

        System.out.println(orangesRotting(grid1)); // 4

        int[][] grid2 = {
                {1,0,1},
                {0,2,0},
                {1,0,1}
        };

        System.out.println(orangesRotting(grid2)); // -1
    }

    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }

                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };

        // Step 2: BFS
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nc < 0 ||
                            nr >= rows || nc >= cols ||
                            grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{nr, nc});
                    rottedThisMinute = true;
                }
            }

            if (rottedThisMinute) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
