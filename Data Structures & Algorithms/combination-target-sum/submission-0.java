class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        compute(nums,target,0,new ArrayList<Integer>(), 0);
        return result;   
    }

    public void compute(int[] nums, int target, int start, List<Integer> current, int currentSum) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current)); // Add a copy of the list
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (currentSum + nums[i] <= target) {
                current.add(nums[i]);
                // Pass 'i' to allow reusing the same number
                compute(nums, target, i, current, currentSum + nums[i]);
                // Backtrack: remove the last element
                current.remove(current.size() - 1);
            }
        }
    }
}
