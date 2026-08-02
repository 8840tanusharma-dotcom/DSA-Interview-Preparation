class Solution {
    public int[] concatWithReverse(int[] nums) {
        
        int n=nums.length;
        int []ans = new int[2*n];
        int left =0;
        int right=n-1;
        for(int i=0;i<n;i++){
          ans[i]=nums[i];
      }
      while(left<n){
        ans[left+n]=ans[right];
         left++;
        right--;
      }
      
     
     return ans;
    }
}