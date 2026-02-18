package graph.bfs.wallsAndGates;

import java.util.*;

public class WallsAndGates {

    private static final int INF = 2147483647;

    public static void main(String[] args) {

        int[][] grid = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        wallsAndGates(grid);

        printGrid(grid);
    }

    public static void wallsAndGates(int[][] rooms) {

        if (rooms == null || rooms.length == 0)
            return;

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasure cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rooms[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1}
        };

        // Step 2: BFS
        while (!queue.isEmpty()) {

            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 ||
                        nr >= rows || nc >= cols ||
                        rooms[nr][nc] != INF) {
                    continue;
                }

                rooms[nr][nc] = rooms[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
