class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int m=mat.length;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    sum1+=mat[i][j];
                }
                if(i+j == n-1){
                    sum2+=mat[i][j];
                }
            }
        }
        int val=0;
        if(n%2!=0 && m%2!=0){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                      val = mat[n/2][m/2];
                }
                
            }
        }
            return sum1+sum2-val;
        }
    
}