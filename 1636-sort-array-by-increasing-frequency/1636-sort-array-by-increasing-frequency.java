class Solution {
    public int[] frequencySort(int[] nums) {
       int n=nums.length;
       int[] count =  new int[201];
       for(int num:nums){
        count[num+100]++;
       }
       Integer[] arr= Arrays.stream(nums).boxed().toArray(Integer[]::new);
       Arrays.sort(arr,(a,b)->{
        if(count[a+100]==count[b+100]){
            return b-a;
        }
        return count[a+100]-count[b+100];
       });
       return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();

    }
}