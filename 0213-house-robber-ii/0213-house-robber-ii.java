class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return(nums[0]);
        if(nums.length==2)return(Math.max(nums[0],nums[1]));
        int case1= robbery(nums,0,nums.length-2);
        int case2 =robbery(nums,1,nums.length-1);
        return Math.max(case1,case2);
    }
        private int robbery(int[]nums,int start,int end){
        int best =0;
       int  last =0;
       for(int i=start;i<=end;i++){
        int pick = nums[i]+last;
        int skip = best;
        int current = Math.max(pick,skip);

        last = best;
        best=current;
       }
       return best;
    }
    }
