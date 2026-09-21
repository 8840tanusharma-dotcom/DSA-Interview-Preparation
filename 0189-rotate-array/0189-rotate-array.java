class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int result[]=new int[n];
        for(int i=0;i<k;i++){
          result[i]=nums[n-k+i];
        }
        for(int i=k;i<n;i++){
            result[i]=nums[i-k];
        }
        for(int i=0;i<n;i++){
            nums[i]= result[i];
        }
    }
}