class Solution {
    static final int[][][] mad = {{{1, 1}, {1, 1}}, {{0, 1}, {1, 0}}};
    static final int MOD = 1000000007; 
    public int uniquePaths(int[][] grid) {
        int n = grid[0].length;
        int left =0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int[] row : grid){
            left =0;
            for(int j=0;j<n;j++){
                int top = dp[j];
                int c = row[j];
                dp[j] = (left * mad[c][1][0] + top * mad[c][1][1]) % MOD;
                left = (left * mad[c][0][0] + top * mad[c][0][1]) % MOD;
            }
        }
        return left;
    }
}