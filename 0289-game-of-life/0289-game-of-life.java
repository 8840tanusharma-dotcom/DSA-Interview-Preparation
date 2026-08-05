class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] dirs={
            {-1,-1},{-1,0},{-1,1},
            {0,-1},       {0,1},
            {1,-1},{1,0},{1,1}
        };
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int neigh =0;
                for(int[] d: dirs){
                    int row = i+d[0];
                    int col = j+d[1];
                    if(row>=0 && row<m && col>=0 && col<n){
                        if(board[row][col]==1 || board[row][col]==-1){
                            neigh++;
                        }
                    }
                }
                if(board[i][j]==1&&(neigh<2 || neigh>3)){
                    board[i][j]= -1;
                }
                if(board[i][j]==0 && neigh==3){
                    board[i][j]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]>0){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }
    }
}