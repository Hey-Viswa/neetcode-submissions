class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int today = 0; today < temperatures.length; today++){
            while(!stack.isEmpty() && temperatures[today] > temperatures[stack.peek()]){
                int waitingDay = stack.pop();
                result[waitingDay] = today - waitingDay;
            }
            stack.push(today);
        }
        return result;
    }
}
