class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        gen("", 0,0,n);
        return this.result;
    }

    public void gen(String current, int left, int right, int n) {
        if (left == n && right == n) {
            this.result.add(current);
            return;
        }

        if (left < n) {
            gen(current + "(", left+1, right, n);
        }

        if (right < left && right < n) {
            gen(current + ")", left, right+1, n);
        }
    }
}
