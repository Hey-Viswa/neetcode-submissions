 class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] result = new int[n];
            // Stack stores indices of days waiting for a warmer temperature
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // While today is warmer than the day at the top of the stack
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int prevIndex = stack.pop();
                    result[prevIndex] = i - prevIndex;
                }
                // Push current day index to wait for its warmer day
                stack.push(i);
            }

            return result;
        }
    }