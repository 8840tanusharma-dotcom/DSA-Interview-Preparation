import java.util.Vector;

class Solution {
    public int minSwaps(int[][] grid) {
        int n= grid.length;
        Vector<Integer> tz= new Vector<>(n);
        for(int i=0;i<n;i++){
            int zc=0;
            int j = n-1;
            while(j>=0 && grid[i][j]==0){
                zc++;
                j--;
            }
            tz.add(zc);
        }
            int ans =0;
            for(int i=0;i<n;i++){
           int tar = n-i-1;
           int j=i;
           while(j<n && tz.get(j)<tar){
            j++;
           }
         if(j==n)return -1;

            while(j>i){
                tz.set(j,tz.get(j-1));
                j--;
                ans++;
            }
            }
        
        return ans;
    }
}