class Solution {
    public int missingNumber(int[] nums) {
        // long size = nums.length;
        // long sum=0;
        // long result = (size*(size+1))/2;
        // for(int i=0;i<nums.length;i++){
        //     sum += nums[i];
        // }
        // return (int)(result - sum);
        int n= nums.length;
       
        for(int i=0;i<=n;i++){
            boolean found = false;
            for(int j=0;j<n;j++){
                if(nums[j]==i){
                    found = true;
                    break;
                }
    
                           }
    if(!found){
        return i;
    }
        }
            return -1;
        
    }
}