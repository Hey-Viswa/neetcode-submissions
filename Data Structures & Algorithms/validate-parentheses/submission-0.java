 class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');
                else {
                    // Must be a closing bracket
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }