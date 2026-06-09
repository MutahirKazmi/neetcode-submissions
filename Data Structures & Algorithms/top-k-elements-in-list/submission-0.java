class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (priorityQueue.isEmpty()) {
                return result;
            }
            result[i] = priorityQueue.poll()[0];
        }

        return result;
    }
}
