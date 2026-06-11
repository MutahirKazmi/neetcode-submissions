class Solution {
    public int findMin(int[] nums) {
        int start = 0; 
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (start <= end) {
            int middle = (start + end) / 2;

            min = Math.min(min, nums[middle]);
            
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else if (nums[start] < nums[middle]) {
                end = middle - 1;
            } else if (middle > 0 && nums[middle-1] < nums[middle]) {
                end = middle - 1;
            } else if (middle < nums.length - 1 && nums[middle+1] < nums[middle]) {
                start = middle + 1;
            } else {
                return min;
            }
        }
        
        return min;
    }
}