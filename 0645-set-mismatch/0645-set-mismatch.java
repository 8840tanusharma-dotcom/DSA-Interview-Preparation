class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int missing  = -1;
        int dup = -1;
        int[] freq= new int[n+1];
        for(int num : nums){
            freq[num]++;
        }
        for(int i=1;i<=nums.length;i++){
            if(freq[i]==0){
                missing = i;
            } 
             if(freq[i]==2){
                dup =i;
            }
        }
        return new int[]{dup,missing};
    }
}