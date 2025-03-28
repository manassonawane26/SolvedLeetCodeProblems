class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            // Popping all indices with a lower or equal
            // temperature than the current index
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) 
                stack.pop();

            // If the stack still has elements,
            // then the next warmer temperature exists!
            if(!stack.isEmpty())
                result[i] = stack.peek() - i;

            // Inserting current index in the stack
            stack.push(i);
        }
        return result;
    }
}