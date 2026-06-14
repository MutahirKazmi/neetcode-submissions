class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            if (n == 1) {
                return true;
            }
            
            if (set.contains(n)) {
                return false;
            }

            set.add(n);
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            int temp = 0;
            for (char ch : chars) {
                temp = temp + ((ch - '0')*(ch - '0'));
            }
            n = temp;

        }
    }
}
