class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("*") && !token.equals("-") && !token.equals("+") && !token.equals("/")) {
                stack.push(Integer.valueOf(token));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                if (token.equals("*")) {
                    stack.push(first*second);
                } else if (token.equals("-")) {
                    stack.push(first-second);
                } else if (token.equals("+")) {
                    stack.push(first+second);
                } else if (token.equals("/")) {
                    if (first == 0) {
                        stack.push(0);
                    } else {
                        stack.push(first/second);
                    }
                }
            }
        }

        return stack.pop();
    }
}
