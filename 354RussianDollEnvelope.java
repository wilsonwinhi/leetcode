class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> ((a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0])));
        for (int[] envelope : envelopes) {
            pq.offer(envelope);
        }
        int[] tails = new int[envelopes.length];
        int sz = 0;
        tails[sz++] = pq.poll()[1];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] < tails[0]) {
                tails[0] = curr[1];
            } else if (curr[1] > tails[sz - 1]) {
                tails[sz++] = curr[1];
            } else {
                int l = 0, r = sz - 1;
                while (l + 1 < r) {
                    int mid = l + (r - l) / 2;
                    if (curr[1] >= tails[mid]) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                if (tails[l] >= curr[1]) tails[l] = curr[1];
                else tails[r] = curr[1];
            }
        }
        return sz;
    }
}
