class Solution {
    public int largestAltitude(int[] gain) {
        int altitude =0;
        int max =0;
        for(int i=0;i<=gain.length-1;i++){
            altitude += gain[i];
            max= Math.max(max,altitude);
        }
        return max;
    }
}