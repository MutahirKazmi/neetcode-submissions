class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                builder.append(s.charAt(i));
            }
        }
        s = builder.toString().toLowerCase();

        int right = s.length() / 2;
        int left;
        if (s.length() %2 != 0) {
            left = right;
        } else {
            left = right - 1;
        }


        while (left >= 0 && right < s.length()) {
            if (s.charAt(right) == s.charAt(left)) {
                left--;
                right++;
            } else {
                return false;
            }
        }

        return true;
    }
}
