class Solution {
    private int[][] grid;
    private int m,n;
    private boolean close(int i, int j){
        if(i<0 || i>=m || j<0 || j>=n)return false;
        if(grid[i][j] == 1)return true;
        grid[i][j] = 1;
        return close(i+1, j) & close(i-1, j) & close(i, j+1) & close(i, j-1); 
    }
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 && close(i, j))count++;
            }
        }
        return count;
    }
}