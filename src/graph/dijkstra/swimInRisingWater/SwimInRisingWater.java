package graph.dijkstra.swimInRisingWater;

import java.util.*;

public class SwimInRisingWater {

    public static void main(String[] args) {

        int[][] grid = {
                {0,1,2,10},
                {9,14,4,13},
                {12,3,8,15},
                {11,5,7,6}
        };

        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // {row, col, maxElevationSoFar}
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] directions = {
                {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int r = current[0];
            int c = current[1];
            int maxElev = current[2];

            if (r == n - 1 && c == n - 1)
                return maxElev;

            if (visited[r][c])
                continue;

            visited[r][c] = true;

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 &&
                        nr < n && nc < n &&
                        !visited[nr][nc]) {

                    int newMax =
                            Math.max(maxElev, grid[nr][nc]);

                    pq.offer(new int[]{nr, nc, newMax});
                }
            }
        }

        return -1;
    }
}
