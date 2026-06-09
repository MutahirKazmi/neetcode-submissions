class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Key = number, Value = index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // Return the index of the complement and current index
                return new int[] { map.get(complement), i };
            }
            
            // Store the current number and its index
            map.put(nums[i], i);
        }
        
        // Return an empty array or handle error if no solution is found
        return new int[0];
    }
}