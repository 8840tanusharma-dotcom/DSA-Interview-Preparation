class Solution {
    public int mySqrt(int x) {
      if(x<2)return x;
      long l =1;
      long r =x;
      int ans =0;
      while(l<=r){
        long mid = l+(r-l)/2;
        if(mid * mid == x){
            return (int)mid;
        }else if(mid * mid < x){
            ans = (int)mid;
            l = mid+1;
        }else{
            r = mid-1;
        }
      }
return ans;
    }
}