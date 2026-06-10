class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        int left = 0;
        List<Integer> maxes = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // if size is greated, we must remove

            queue.offer(nums[i]);

           if (queue.size() > k) {
                queue.remove(nums[left]);
                left++;
            }

            if (queue.size() == k) {
                maxes.add(queue.peek());
            }
                        
        }

        int[] array = new int[maxes.size()];
        for(int i = 0; i < maxes.size(); i++) array[i] = maxes.get(i);
        return array;
    }
}
