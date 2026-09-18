class Solution {
    public int removeDuplicates(int[] nums) {
        // int k=1;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i] != nums[i-1]){
        //         nums[k]=nums[i];
        //         k++;
        //     }
        // }
        // return k;
        int i =0;
        for(int j=i+1;j<nums.length;j++){
        if(nums[i]!=nums[j]){
            i++;
            nums[i]=nums[j];
        }
        }
        return i+1;
       
}
}