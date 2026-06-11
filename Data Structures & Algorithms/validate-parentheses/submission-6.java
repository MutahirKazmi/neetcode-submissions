class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];

            if (curr == '[' || curr == '(' || curr == '{') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char popped = stack.pop();
                if (curr == ']' && popped != '[') {
                    return false;
                } else if (curr == '}' && popped != '{') {
                    return false;
                } else if (curr == ')' && popped != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
