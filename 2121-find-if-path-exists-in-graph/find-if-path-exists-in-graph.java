// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for(int i=0; i<n; i++){
//             graph.add(new ArrayList<Integer>());
//         }
//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             graph.get(u).add(v);
//             graph.get(v).add(u);
//         }
//         Set<Integer> visited = new HashSet<>();

//         //logic to print graph
//         // for(int i=0;i<graph.size();i++){
//         //     System.out.print("Node " +i);
//         //     for(int j=0;j<graph.get(i).size(); j++){
//         //         System.out.print(" => " + graph.get(i).get(j));
//         //     }
//         //     System.out.println();
//         // }

//         return dfs(source, destination, graph, visited);
//     }
    
//     private boolean dfs(int node, int destination, List<List<Integer>> graph, Set<Integer> visited){
//         if(node == destination) return true;
//         visited.add(node);
        
//         for(int i : graph.get(node)) {
//             // System.out.println("Node: " +node);
//             if(!visited.contains(i) && dfs(i, destination, graph, visited)) 
//                 return true;

//         }
//         return false;
//     }
// }

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();

        //logic to print graph
        // for(int i=0;i<graph.size();i++){
        //     System.out.print("Node " +i);
        //     for(int j=0;j<graph.get(i).size(); j++){
        //         System.out.print(" => " + graph.get(i).get(j));
        //     }
        //     System.out.println();
        // }

        return bfs(source, destination, graph, visited);
    }
    
    private boolean bfs(int node, int destination, List<List<Integer>> graph, Set<Integer> visited){
        if(node == destination) return true;
        Queue<Integer> q= new LinkedList<>();
        visited.add(node);
        q.add(node);
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> connNodes = graph.get(curr);
            if(connNodes!=null){
                for(int i: connNodes){
                    if(!visited.contains(i)){
                        if(i == destination) return true;
                        visited.add(i);
                        q.add(i);
                        
                    }
                }
            }
        }
        return false;
    }
}