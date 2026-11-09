class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> avail = new TreeSet<>();
        for(int i=0; i<k; i++) avail.add(i);
        int n = arrival.length;
        int[] count = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0]-b[0];
        });
        for(int i=0; i<n; i++) {
            while(!pq.isEmpty() && pq.peek()[0] <= arrival[i]) {
                avail.add(pq.poll()[1]);
            }
            if(avail.size()==0) continue;
            Integer cand = avail.ceiling(i%k);
            if(cand == null) {
                cand = avail.first();
            }
            count[cand]++;
            avail.remove(cand);
            pq.offer(new int[]{load[i]+arrival[i], cand});
        }
        int mxm = 0;
        for(int i=0; i<k; i++) {
            mxm = Math.max(mxm, count[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++) {
            if(count[i]==mxm) ans.add(i);
        }
        return ans;
    }
}