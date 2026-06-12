class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>(); // minHeap
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            this.add(nums[i]);
        }
    }
    
    public int add(int val) {
            if (this.queue.size() < k) {
                this.queue.offer(val);
            } else {
                if (this.queue.peek() < val) {
                    this.queue.poll();
                    this.queue.offer(val);
                }
            
            
            }      

        return this.queue.peek();  
    }
}
