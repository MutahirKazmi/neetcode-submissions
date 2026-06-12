class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));
        
        // Iterate starting from 'start' to ensure we only pick elements 
        // that appear AFTER the current one, avoiding permutations.
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);            // Include
            backtrack(result, current, nums, i + 1); // Move to next
            current.remove(current.size() - 1);      // Backtrack
        }
    }
}