class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        
        List<List<Integer>> treeGraph = new ArrayList();
        for(int i = 0; i < n; i++) {
            treeGraph.add(new ArrayList());
        }
        for(int[] edge : edges) {
            treeGraph.get(edge[0]).add(edge[1]);
            treeGraph.get(edge[1]).add(edge[0]);
        }

        return dfs(treeGraph, 0, -1, values, k)[1];
    }

    private int[] dfs(List<List<Integer>> treeGraph, int node, int parent, int[] values, int k) {

        int components = 0;
        int totalValue = values[node];
        
        for(int child : treeGraph.get(node)) {
            if(child == parent) continue;
            int[] childValue = dfs(treeGraph, child, node, values, k);
            components += childValue[1];
            if(childValue[0] != -1) { // child can merge with parent
                totalValue += childValue[0];
            }
        }

        if(totalValue % k == 0) {
            return new int[] {-1, components + 1};
        } else {
            return new int[] { totalValue % k , components};
        }
    }
}