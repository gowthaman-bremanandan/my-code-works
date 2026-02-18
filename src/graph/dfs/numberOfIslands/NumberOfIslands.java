package graph.dfs.numberOfIslands;

public class NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid1 = {
                {'0','1','1','1','0'},
                {'0','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid1)); // 1

        char[][] grid2 = {
                {'1','1','0','0','1'},
                {'1','1','0','0','1'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid2)); // 4
    }

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {

        if (r < 0 || c < 0 ||
                r >= grid.length || c >= grid[0].length ||
                grid[r][c] == '0') {
            return;
        }

        // Mark as visited (sink island)
        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
