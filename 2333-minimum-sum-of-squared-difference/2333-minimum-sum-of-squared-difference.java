class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
       int n = nums1.length;
       int k = k1+k2;
       int[] diff = new int[n];
       int max =0;
       for(int i=0;i<n;i++){
        
        diff[i] = Math.abs(nums1[i]-nums2[i]);
        max = Math.max(max,diff[i]);
       }
       int[] fre = new int[max+1];
       for(int d : diff){
        fre[d]++;
       }
       for(int d = max;d>0 && k>0;d--){
        if(fre[d]>0){
            int min = Math.min(k,fre[d]);
            fre[d]-=min;
            fre[d-1]+=min;
            k-=min;
        }
       }
       
       long sum =0;
      for(int d =1;d<=max;d++){
        if(fre[d]>0){
       sum += (long)d*d*fre[d];
        }
      }
      return sum;
        
    }
}