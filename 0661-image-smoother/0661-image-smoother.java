class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int [m][n];
        int[][] dirs = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,0},{0,1},
            {1,-1},{1,0},{1,1}
        };
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 int sum=0;
                 int count=0;
                 for(int[] d:dirs){
                    int r = i+d[0];
                    int c = j+d[1];
                    if(r>=0 && r<m && c>=0 && c<n){
                        sum += img[r][c];
                        count++;
                    }
                 }
                 result[i][j] = sum/count;
            }
        }
        return result;
    }
}