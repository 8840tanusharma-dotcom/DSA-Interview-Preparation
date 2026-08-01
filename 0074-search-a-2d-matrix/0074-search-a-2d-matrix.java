class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=m*n-1;
        while (i<=j){
            int mid = i+(j-i)/2;
            int midval = matrix[mid/n][mid%n];
            if(midval==target){
                return true;
            }else if(target>midval){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return false;
    }
}