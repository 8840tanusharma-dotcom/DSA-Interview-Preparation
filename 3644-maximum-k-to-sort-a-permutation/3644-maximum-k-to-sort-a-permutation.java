class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int a = -1;
        for(int i=0;i<n;i++){
            if(nums[i] != i){
                a &= nums[i];
                if(a == 0) return 0;
            }
        }
        return Math.max(a, 0);
    }
}