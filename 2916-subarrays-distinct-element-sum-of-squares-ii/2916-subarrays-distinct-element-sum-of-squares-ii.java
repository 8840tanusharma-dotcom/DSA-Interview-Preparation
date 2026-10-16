class Solution {
    private static final long MOD = 1_000_000_007L;

    class SegmentTree {
        long[] sum;
        long[] sqSum;
        long[] lazy;

        SegmentTree(int n) {
            sum = new long[4 * n];
            sqSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        private void apply(int idx, int l, int r, long add) {
            long len = r - l + 1;

            sqSum[idx] = (
                    sqSum[idx]
                    + 2L * add % MOD * sum[idx] % MOD
                    + len % MOD * add % MOD * add % MOD
            ) % MOD;

            sum[idx] = (sum[idx] + len % MOD * add) % MOD;
            lazy[idx] = (lazy[idx] + add) % MOD;
        }

        private void push(int idx, int l, int r) {
            if (lazy[idx] == 0) return;

            int mid = (l + r) >> 1;

            apply(idx * 2, l, mid, lazy[idx]);
            apply(idx * 2 + 1, mid + 1, r, lazy[idx]);

            lazy[idx] = 0;
        }

        public void update(int idx, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(idx, l, r, 1);
                return;
            }

            push(idx, l, r);

            int mid = (l + r) >> 1;

            update(idx * 2, l, mid, ql, qr);
            update(idx * 2 + 1, mid + 1, r, ql, qr);

            sum[idx] = (sum[idx * 2] + sum[idx * 2 + 1]) % MOD;
            sqSum[idx] = (sqSum[idx * 2] + sqSum[idx * 2 + 1]) % MOD;
        }

        public long totalSqSum() {
            return sqSum[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree st = new SegmentTree(n);

        Map<Integer, Integer> last = new HashMap<>();

        long ans = 0;

        for (int r = 0; r < n; r++) {
            int prev = last.getOrDefault(nums[r], -1);

            st.update(1, 0, n - 1, prev + 1, r);

            ans = (ans + st.totalSqSum()) % MOD;

            last.put(nums[r], r);
        }

        return (int) ans;
    }
}