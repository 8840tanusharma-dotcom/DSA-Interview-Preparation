class Solution {
    public int rob(int[] nums) {
       int best =0;
       int  last =0;
       for(int i=0;i<nums.length;i++){
        int pick = nums[i]+last;
        int skip = best;
        int current = Math.max(pick,skip);

        last = best;
        best=current;
       }
       return best;
    }
}