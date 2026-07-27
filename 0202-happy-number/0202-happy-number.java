class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> res = new HashSet<>();
        while(n != 1 && !res.contains(n)){
        res.add(n);
        n = sumOfSqr(n);
    }
    return n== 1;
    }

    private int sumOfSqr(int num){
        int sum =0;
        while(num>0){
            int digit = num%10;
            sum += digit*digit;
            num/=10;
        }
        return sum;
    }
}