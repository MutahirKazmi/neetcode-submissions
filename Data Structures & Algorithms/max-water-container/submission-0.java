class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int result = Integer.MIN_VALUE;
        
        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            result = Math.max(result, height * width);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
