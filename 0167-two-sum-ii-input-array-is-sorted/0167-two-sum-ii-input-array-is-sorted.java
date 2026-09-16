class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int start =0;
        int last = numbers.length-1;
       while(start<last){
            if(numbers[start] + numbers[last] == target){
                return new int[]{start+1,last+1};
            }else if(numbers[start]+numbers[last] < target){
                start++;
            }else{
                last--;
            }
        }
        return new int[]{-1,-1};
    }
}