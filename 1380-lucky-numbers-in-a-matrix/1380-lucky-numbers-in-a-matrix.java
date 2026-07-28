class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        int[] min = new int[n];
        int[] max = new int[m];
        for(int i=0;i<n;i++){
             min[i] = Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                min[i]= Math.min(min[i],matrix[i][j]);
            }
        }  
        for(int j=0;j<m;j++){
             max[j]= Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max[j]= Math.max(max[j],matrix[i][j]);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==min[i] && matrix[i][j]==max[j]){
                    res.add(matrix[i][j]);
                }
            }
            }
            return res;
        }

    
}