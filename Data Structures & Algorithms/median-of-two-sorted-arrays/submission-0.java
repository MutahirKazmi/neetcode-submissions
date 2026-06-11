class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        populateQueue(nums1);
        populateQueue(nums2);
        
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.poll();
        } else {
            return (maxHeap.poll() + minHeap.poll()) * 0.5;
        }
    }
    
    public void populateQueue(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            minHeap.add(maxHeap.poll());
            
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
    }}
