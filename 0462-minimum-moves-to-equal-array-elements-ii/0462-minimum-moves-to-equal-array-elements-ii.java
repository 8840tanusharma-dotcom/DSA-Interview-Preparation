class Solution {
    private static final Random ran = new Random();

    public int minMoves2(int[] nums) {
        int med = quick(nums, nums.length/2);
        int moves =0;
        for(int x : nums) moves += Math.abs(x-med);
        return moves;
    }

    private static int quick(int[] a, int k){
        int l =0;
        int hi = a.length-1;
        while(true){
            int pivot = a[l + ran.nextInt(hi - l + 1)];
            int lt = l;
            int i = l;
            int gt = hi;
            while( i <= gt){
                if(a[i] < pivot)swap(a, lt++, i++);
                else if(a[i] > pivot) swap(a, i , gt--);
                else i++;
            }
            if(k < lt) hi = lt -1;
            else if(k > gt) l = gt + 1;
            else return pivot;

        }
    }
    private static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}