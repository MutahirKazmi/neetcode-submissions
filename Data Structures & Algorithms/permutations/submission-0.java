class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        compute(nums,new ArrayList<>(),marked);
        return this.result;        
    }

    public void compute(int[] nums, List<Integer> subList, boolean[] marked) {
        if (subList.size() == nums.length) {
            this.result.add(new ArrayList<>(subList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                subList.add(nums[i]);
                compute(nums,subList,marked);
                subList.remove(subList.size()-1);
                marked[i] = false;
            }
        }
    }
}
