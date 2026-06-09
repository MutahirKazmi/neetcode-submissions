class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // The pointer for the next position
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[k] = nums[j];
                k++;
            }
        }
        return k; // 'k' now represents the count of elements not equal to 'val'
    }
}