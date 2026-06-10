class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int startIndex = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                length = Math.max(length, i - startIndex);
                while (s.charAt(startIndex) != s.charAt(i)) {
                    set.remove(s.charAt(startIndex));
                    startIndex++;
                }

                startIndex++;
            }
        }

        return Math.max(length, s.length() - startIndex);
    }
}
