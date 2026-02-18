package graph.dfs.maxAreaOfIsland;

public class MaxAreaOfIsland {

    public static void main(String[] args) {

        int[][] grid = {
                {0,1,1,0,1},
                {1,0,1,0,1},
                {0,1,1,0,1},
                {0,1,0,0,1}
        };

        System.out.println(maxAreaOfIsland(grid)); // 6
    }

    public static int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 1) {

                    int area = dfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c) {

        if (r < 0 || c < 0 ||
                r >= grid.length || c >= grid[0].length ||
                grid[r][c] == 0) {
            return 0;
        }

        // Mark visited
        grid[r][c] = 0;

        int area = 1;

        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);

        return area;
    }
}
