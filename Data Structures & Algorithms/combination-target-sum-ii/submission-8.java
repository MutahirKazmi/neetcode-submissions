class Solution {

    Set<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.result = new HashSet<>();
        Arrays.sort(candidates);
        compute(candidates,target,0,new ArrayList<Integer>(), 0);
        return new ArrayList<>(this.result);           
    }

    public void compute(int[] nums, int target, int start, List<Integer> current, int currentSum) {
        if (currentSum == target) {
            List<Integer> temp = new ArrayList<>(current);
            this.result.add(temp); // Add a copy of the list
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (currentSum + nums[i] > target) break;

            if (currentSum + nums[i] <= target) {
                current.add(nums[i]);
                compute(nums, target, i+1, current, currentSum + nums[i]);
                current.remove(current.size() - 1);
            }
        }
    }
}
