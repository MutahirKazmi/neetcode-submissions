class Solution {
    private Set<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        this.result = new HashSet<>();
        compute(stack, nums, 0);
        return new ArrayList<>(this.result);
    }

    public void compute(Stack<Integer> stack, int[] nums, int i) {
        this.result.add(new ArrayList<Integer>(stack));
        
        for (;i < nums.length; i++) {
            stack.push(nums[i]);
            compute(stack, nums, i+1);
            stack.pop();                
        }
    }
}
