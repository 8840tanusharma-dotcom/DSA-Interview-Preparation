class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
       Integer[] sorted = new Integer[n];

for (int i = 0; i < n; i++) {
    sorted[i] = nums[i];
}

Arrays.sort(sorted, (a, b) -> {
    int s1 = digitSum(a);
    int s2 = digitSum(b);

    if (s1 != s2) return s1 - s2;
    return a - b;
});
        Map<Integer,Integer> ans = new HashMap<>();
        for(int i=0;i<n;i++){
            ans.put(nums[i], i);
        }
            int swap =0;
            for(int i=0;i<n;i++){
                if(nums[i] == sorted[i])continue;
                swap++;
                int crtIdx = ans.get(sorted[i]);
                ans.put(nums[i],crtIdx);
                ans.put(sorted[i], i);
                int temp = nums[i];
                nums[i] = nums[crtIdx];
                nums[crtIdx] = temp;
            }
            return swap;
        }
        private int digitSum(int x){
            int sum =0;
            while(x > 0){
                sum += x%10;
                x /=10;
            }
            return sum;
        }
    }
