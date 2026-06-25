public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : set) {
            // Only start counting if this is the start of a sequence
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currentStreak = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    currentStreak++;
                }

                max = Math.max(max, currentStreak);
            }
        }
        return max;
    }
}