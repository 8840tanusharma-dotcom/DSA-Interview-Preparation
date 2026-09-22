class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
       int count1=0;
       int count2=0;
       int count3=0;
       for(int i=0;i<n;i++){
        if(nums[i]==0){
            count1++;
        }else if(nums[i]==1){
            count2++;
        }else{
            count3++;
        }
       }
       int index =0;
        while(count1>0){
            nums[index]=0;
        count1--;
        index++;
        }
        while(count2>0){
            nums[index]=1;
        count2--;
        index++;
        }
        while(count3>0){
            nums[index]=2;
        count3--;
        index++;
        }
       
    }
}