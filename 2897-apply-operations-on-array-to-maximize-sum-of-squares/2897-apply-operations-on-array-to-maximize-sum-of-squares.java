class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1000000007L;
        int[] arr = new int[32];
        for(int num : nums){
            for(int i =0;i<32;i++){
                if(((num >> i) & 1) == 1){
                    arr[i]++;
                }
            }
        }
        long res =0;
        for(int i =0;i<k;i++){
            long cur =0;
            for(int j=0;j<32;j++){
                if(arr[j] > 0){
                    cur |= (1L << j);
                    arr[j]--;
                }
            }
            res = (res + (cur * cur) % mod) % mod;
        }
        return (int)res;
    }
}