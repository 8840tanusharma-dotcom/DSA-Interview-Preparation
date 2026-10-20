class Solution {
    public int sortableIntegers(int[] nums) {
       
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        long ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean ok = true;

            for (int start = 0; start < n; start += k) {
                if (!isRotation(nums, sorted, start, k)) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans += k;
        }

        return (int) ans;
    }

    private boolean isRotation(int[] nums, int[] sorted, int start, int len) {

        int[] text = new int[2 * len];
        int[] pattern = new int[len];

        for (int i = 0; i < len; i++) {
            text[i] = nums[start + i];
            text[i + len] = nums[start + i];
            pattern[i] = sorted[start + i];
        }

        return kmp(text, pattern);
    }

    private boolean kmp(int[] text, int[] pattern) {

        int n = text.length;
        int m = pattern.length;

        int[] lps = new int[m];

        int len = 0;
        for (int i = 1; i < m; ) {
            if (pattern[i] == pattern[len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }

        for (int i = 0, j = 0; i < n; ) {
            if (text[i] == pattern[j]) {
                i++;
                j++;

                if (j == m) {
                    return true;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }
}