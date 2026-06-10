class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0; 
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

            while (r-l+1 - Collections.max(count.values()) > k) {
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
