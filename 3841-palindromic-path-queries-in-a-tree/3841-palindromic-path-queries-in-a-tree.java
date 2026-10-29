import java.util.*;

class Solution {

    List<Integer>[] graph;
    int[] parent, depth, size, heavy;
    int[] head, pos;
    int curPos;
    char[] chars;
    SegmentTree seg;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        chars = s.toCharArray();

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        Arrays.fill(heavy, -1);

        dfs(0, -1);

        head = new int[n];
        pos = new int[n];
        curPos = 0;

        decompose(0, 0);

        int[] base = new int[n];
        for (int i = 0; i < n; i++) {
            base[pos[i]] = 1 << (chars[i] - 'a');
        }

        seg = new SegmentTree(base);

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {

            String[] p = q.split(" ");

            if (p[0].equals("update")) {

                int node = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                chars[node] = c;
                seg.update(pos[node], 1 << (c - 'a'));

            } else {

                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int mask = queryPath(u, v);

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private int dfs(int u, int p) {

        parent[u] = p;
        size[u] = 1;

        int best = 0;

        for (int v : graph[u]) {

            if (v == p) continue;

            depth[v] = depth[u] + 1;

            int sub = dfs(v, u);

            size[u] += sub;

            if (sub > best) {
                best = sub;
                heavy[u] = v;
            }
        }

        return size[u];
    }

    private void decompose(int u, int h) {

        head[u] = h;
        pos[u] = curPos++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : graph[u]) {

            if (v == parent[u] || v == heavy[u]) continue;

            decompose(v, v);
        }
    }

    private int queryPath(int a, int b) {

        int res = 0;

        while (head[a] != head[b]) {

            if (depth[head[a]] < depth[head[b]]) {
                int t = a;
                a = b;
                b = t;
            }

            res ^= seg.query(pos[head[a]], pos[a]);

            a = parent[head[a]];
        }

        if (depth[a] > depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        res ^= seg.query(pos[a], pos[b]);

        return res;
    }

    static class SegmentTree {

        int n;
        int[] tree;

        SegmentTree(int[] arr) {

            n = arr.length;
            tree = new int[4 * n];

            build(1, 0, n - 1, arr);
        }

        private void build(int node, int l, int r, int[] arr) {

            if (l == r) {
                tree[node] = arr[l];
                return;
            }

            int mid = (l + r) >>> 1;

            build(node << 1, l, mid, arr);
            build(node << 1 | 1, mid + 1, r, arr);

            tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int node, int l, int r, int idx, int val) {

            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) >>> 1;

            if (idx <= mid) {
                update(node << 1, l, mid, idx, val);
            } else {
                update(node << 1 | 1, mid + 1, r, idx, val);
            }

            tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
        }

        int query(int L, int R) {
            return query(1, 0, n - 1, L, R);
        }

        private int query(int node, int l, int r, int L, int R) {

            if (L <= l && r <= R) {
                return tree[node];
            }

            int mid = (l + r) >>> 1;
            int ans = 0;

            if (L <= mid) {
                ans ^= query(node << 1, l, mid, L, R);
            }

            if (R > mid) {
                ans ^= query(node << 1 | 1, mid + 1, r, L, R);
            }

            return ans;
        }
    }
}