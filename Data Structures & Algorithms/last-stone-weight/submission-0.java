class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            q.offer(stones[i]);
        }

        while (q.size() > 0) {
            if (q.size() >= 2) {
                int first = q.poll();
                int second = q.poll();

                if (first != second) {
                    q.offer(first-second);
                }
            } else if (q.size() == 1) {
                return q.poll();
            }
        }

        return 0;
    }
}
