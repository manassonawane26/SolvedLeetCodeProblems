class Solution {
    int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList());
        for(List<Integer> it : connections){
            int u = it.get(0);
            int v = it.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] visited = new int[n];
        int[] tin= new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, graph, tin, low, bridges);
        return bridges;
    }

    private void dfs(int node, int parent, int[] visited, List<List<Integer>> adj, int[] tin, int[] low, List<List<Integer>> bridges){
        visited[node] = 1;
        low[node] = tin[node] = timer++;
        for(Integer it: adj.get(node)){
            if(it == parent) continue;
            if(visited[it]==0){
                dfs(it, node, visited, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > tin[node])
                    bridges.add(Arrays.asList(it, node));
            }
            else{
                low[node]=Math.min(low[node], low[it]);
            }
        }
    }
}