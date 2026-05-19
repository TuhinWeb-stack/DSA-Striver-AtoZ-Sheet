public class NumberOfIslands {
    public int numIsland(char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    dfsSink(grid, i, j);
                }
            }
        }
        return islandCount;
    }
    
    private void dfsSink(char[][] grid, int startRow, int startCol){
        int Rows = grid.length;
        int Cols = grid[0].length;
        
        // FIXED: Changed '>' to '>=' to prevent index out of bounds crashes
        if(startRow < 0 || startRow >= Rows || startCol < 0 || startCol >= Cols || grid[startRow][startCol] == '0'){
            return;
        }
        grid[startRow][startCol] = '0';

        dfsSink(grid, startRow - 1, startCol);
        dfsSink(grid, startRow + 1, startCol);
        dfsSink(grid, startRow, startCol - 1);
        dfsSink(grid, startRow, startCol + 1);
    }
    
    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();

        System.out.println("--- RUNNING LEETCODE NUMBER OF ISLANDS (DFS) ---");

        // -------------------------------------------------------------
        // LEETCODE EXAMPLE 1: All land is connected (Expected Output: 1)
        // -------------------------------------------------------------
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        
        // FIXED: Changed method call name to 'numIsland' to match the function declaration
        int result1 = solver.numIsland(grid1);
        System.out.println("Example 1 Result: " + result1 + " (Expected: 1)");

        // -------------------------------------------------------------
        // LEETCODE EXAMPLE 2: 3 disconnected chunks (Expected Output: 3)
        // -------------------------------------------------------------
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
        // FIXED: Removed the extra 's' to correctly match 'numIsland'
        int result2 = solver.numIsland(grid2);
        System.out.println("Example 2 Result: " + result2 + " (Expected: 3)");
    }
}