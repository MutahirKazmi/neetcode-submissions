class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            boolean sameChar = true;
            Character charac = null;
            for (String str : strs) {
                if (charac == null) {
                    charac = str.charAt(i);
                }

                if (str.charAt(i) != charac) {
                    return builder.toString();
                }
            }

            builder.append(charac);
        }

        return builder.toString();
    }
}