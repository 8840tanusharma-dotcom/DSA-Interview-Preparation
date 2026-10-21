class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char minimum = s.charAt(0);
        char maximum = s.charAt(0);
        boolean isSorted = true;
        for(int i=1;i<n;i++){
            if(s.charAt(i) < s.charAt(i-1))isSorted = false;
            if(s.charAt(i) < minimum) minimum = s.charAt(i);
            if(s.charAt(i) > maximum) maximum = s.charAt(i);
        }
        if(isSorted) return 0;
        if(n == 2) return -1;
        if(s.charAt(0) == minimum || s.charAt(n-1) == maximum)
        return 1;
        for(int i=1;i<n-1;i++){
        if(s.charAt(i) == minimum || s.charAt(i) == maximum)
        return 2;
        }

    return 3;
    }
}