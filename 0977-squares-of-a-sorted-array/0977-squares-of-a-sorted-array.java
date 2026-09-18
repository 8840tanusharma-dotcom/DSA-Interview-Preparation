class Solution {
    public int[] sortedSquares(int[] nums) {
    //    int[] sq = new int[nums.length] ;
       
       
    //    for(int i=0;i<nums.length;i++){
    //     sq[i] = nums[i]*nums[i];
    //    } 
    //   Arrays.sort(sq);
    //   return sq;
    int []result = new int[nums.length];
    int left =0;
    int right =nums.length-1;
    int leftsq = 0;
    int rightsq = 0;
     int i = nums.length-1;
    while(left<=right){
        leftsq = nums[left]*nums[left];
        rightsq = nums[right]*nums[right];
       
        if(leftsq > rightsq){
            result[i]=leftsq;
            left++; 
            i--;
        }else{
            result[i]=rightsq;
            right--;
            i--;
        }
    }
    
    return result;
    }
}