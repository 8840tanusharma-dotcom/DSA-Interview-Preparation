class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int n= matrix.length;
      int m = matrix[0].length;
      ArrayList<Integer> demo = new ArrayList<>();
      int left =0;
      int top=0;
      int right = m-1;
      int bottom = n-1;
      while(left<=right && top<=bottom){
      for(int i=left;i<=right;i++){
          demo.add(matrix[top][i]);
      }  
      top++;
      for(int i=top;i<=bottom;i++){
      demo.add(matrix[i][right]);
      }
      right--;
      if(top<=bottom){
      for(int i=right;i>=left;i--){
        demo.add(matrix[bottom][i]);
      }
      bottom--;
      }
      if(left<=right){
      for(int i=bottom;i>=top;i--){
        demo.add(matrix[i][left]);
      }
      left++;
      }
      }
      return demo;
    }
}