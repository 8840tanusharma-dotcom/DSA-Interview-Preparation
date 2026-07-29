class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;
        for(int j=0;j<m;j++){
            int i=0;
            int k=j;
            int var = matrix[i][j];
            while(i<n && k<m){
                if(matrix[i][k]!=var)
                return false;
                i++;
                k++;
            }
        }
        for(int i=1;i<n;i++){
            int k=i;
            int j=0;
            int val = matrix[i][j];
            while(j<m && k<n){
            if(matrix[k][j]!=val)
            return false;
            k++;
            j++;
            }

        }
        return true;
    }
}