class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])
            continue;
        
        int left = i+1;
        int right = n-1;
        while(left<right){
        int sum = nums[i]+nums[left]+nums[right];
          if (sum>0){ right--;}
          else if(sum<0) {left++;}
          else {
          res.add(Arrays.asList(nums[i],nums[left],nums[right]));
          left++;
          while(nums[left]==nums[left-1] && left<right){
            left++;

          }
        }
        }
    }
    return res;
    }
}
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(triplet); 
        //                 set.add(triplet);
        //             }
        //         }
        //     }
        // }
        
        // return new ArrayList<>(set);
    

