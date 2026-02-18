package graph.dfs.pacificAtlantic;

import java.util.*;

public class PacificAtlantic {

    public static void main(String[] args) {

        int[][] heights = {
                {4,2,7,3,4},
                {7,4,6,4,7},
                {6,3,5,3,6}
        };

        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0)
            return result;

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific DFS
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, rows - 1, c);
        }

        // Collect intersection
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights,
                            boolean[][] visited,
                            int r,
                            int c) {

        int rows = heights.length;
        int cols = heights[0].length;

        visited[r][c] = true;

        int[][] directions = {
                {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nc < 0 ||
                    nr >= rows || nc >= cols ||
                    visited[nr][nc] ||
                    heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, visited, nr, nc);
        }
    }
}