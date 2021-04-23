package HW8;

public class NumOfIslands {
    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char land = grid[i][j];
                if(land == '1'){
                    checkLand(i, j, grid);
                    islands ++;
                }
            }

        }
        return islands;
    }

    private static void checkLand(int row, int col, char[][] grid) {
        if (col < 0 || row < 0 || col >= grid[0].length || row >= grid.length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        checkLand(row, col + 1, grid);
        checkLand(row, col - 1, grid);
        checkLand(row + 1, col, grid);
        checkLand(row -1, col, grid);


    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'0','0','0','0','0'}};

        System.out.println(numIslands(grid));
    }
}
