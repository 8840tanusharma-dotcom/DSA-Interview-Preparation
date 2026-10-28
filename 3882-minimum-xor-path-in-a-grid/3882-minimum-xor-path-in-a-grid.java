class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] cute = new boolean[n][1024];
        boolean[] near = new boolean[1024];

        cute[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int val = grid[i][j];
                Arrays.fill(near, false);

                for (int k = 0; k < 1024; k++) {
                    if (cute[j][k] || (j > 0 && cute[j - 1][k])) {
                        near[k ^ val] = true;
                    }
                }

                System.arraycopy(near, 0, cute[j], 0, 1024);
            }
        }

        for (int k = 0; k < 1024; k++) {
            if (cute[n - 1][k]) {
                return k;
            }
        }

        return -1;
    }
}