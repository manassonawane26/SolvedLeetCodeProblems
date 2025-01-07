import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create an array to store the minimum cost to reach each node.
        int[] dp = new int[n];
        
        // Initialize the array with maximum values, except for the source node which has cost 0.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        // Iterate through each stop up to k.
        for (int i = 0; i <= k; i++) {
            // Create a temporary array to store the updated costs for this iteration.
            int[] temp = Arrays.copyOf(dp, n);
            
            // Iterate through each flight.
            for (int[] flight : flights) {
                // Check if we can reach the starting node of the current flight from the source node.
                if (dp[flight[0]] != Integer.MAX_VALUE) {
                    // Update the cost to reach the destination node of the current flight if it's cheaper.
                    temp[flight[1]] = Math.min(temp[flight[1]], dp[flight[0]] + flight[2]);
                }
            }
            
            // Update dp array with the temporary array for this iteration.
            dp = temp;
        }
        
        // Return the cost to reach the destination node. If it's still Integer.MAX_VALUE, it means it's not reachable.
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}