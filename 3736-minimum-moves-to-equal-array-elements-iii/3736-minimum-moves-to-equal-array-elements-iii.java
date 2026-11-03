class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            max = Math.max(max, val);
        }
        long ans = 0;
        for(int val : nums){
            ans += (max - val);
        }
          return (int)ans;
    }

}