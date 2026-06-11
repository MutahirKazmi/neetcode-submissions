class Solution {
    boolean down = false;
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Boolean increasing = null;
        int profitSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            int prev = prices[i-1];
            int curr = prices[i];

            if (curr >= prev) {
                min = Math.min(min, prev);
                max = Math.max(max, curr);
                increasing = true;
            } else {
                if (max != Integer.MIN_VALUE || min != Integer.MAX_VALUE) {
                    profitSoFar = profitSoFar + max-min;
                }
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                increasing = false;
            }
        }

        if (increasing != null && true == increasing) {
            profitSoFar = profitSoFar + max-min;
        }

        return profitSoFar;
    }
}