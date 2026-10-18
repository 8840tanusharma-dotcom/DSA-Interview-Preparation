class Solution {
    private static final long MOD = 1_000_000_007L;
    public int numOfWays(int[] nums) {
        int n =nums.length;
        int[] arr = new int[n+2];
        Arrays.fill(arr, -1);
        for(int i=0;i<n;i++) arr[nums[i]] = i;
        long fact = 1;
        long size = 1;
        for(int k=2;k<=n;k++)fact = fact * k % MOD;
        int[] stack = new int[n+2];
        int top =0;
        for(int j=1;j<=n+1;j++){
            while(arr[stack[top]] > arr[j]){
                top--;
                size = size * (j-stack[top]-1) % MOD;
            }
            stack[++top] = j;
        }
        return (int)((fact * power(size, MOD-2) - 1 + MOD)% MOD);
    }
    private long power(long b, long e){
        long r =1; 
        for(b %= MOD; e > 0; e >>= 1, b = b * b % MOD)
        if((e & 1) == 1) 
        r = r * b % MOD;
        return r;
    }
}