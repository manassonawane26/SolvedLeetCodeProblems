// // class Solution {
// //     public boolean isBipartite(int[][] graph) {
// //         int v = graph.length;
// //         int[] color =  new int[v];
// //         Arrays.fill(color, -1);
// //         for(int i=0;i<v; i++) {
// //             if(color[i]==-1){
// //                 if(!bfsCheckBipartite(i, graph, color))
// //                     return false;
// //             }
// //         }
// //         return true;
// //     }

// //     public boolean bfsCheckBipartite(int start, int[][] graph, int[] color){
// //         Queue<Integer> q = new LinkedList<>();
// //         q.add(start);
// //         color[start] = 0;
// //         while(!q.isEmpty()){
// //             int currNode = q.poll();
// //             int currColor = color[currNode];
// //             for(int i =0; i< graph[i].length; i++){
// //                 if(graph[start][i] == 1){
// //                     // System.out.println(start + " " + i);
// //                     if(color[i] == -1){
// //                         color[i] = 1 - currColor;
// //                         q.add(i);
// //                     } else if( color[i] == currColor) return false;
// //                 }
// //             }
// //         }
// //         return true;
// //     }
// // }

// import java.util.*;

// class Solution {
//     private boolean dfs(int node, int colour, List<List<Integer>> graph, int[] color) {
//         color[node] = colour; // Color the current node
//         for (int neighbor : graph.get(node)) {
//             if (color[neighbor] == -1) { 
//                 // If neighbor is uncolored, recursively color it with the opposite color
//                 if (!dfs(neighbor, 1 - colour, graph, color)) {
//                     return false; // Conflict detected
//                 }
//             } else if (color[neighbor] == colour) {
//                 return false; // Conflict detected
//             }
//         }
//         return true; // Successfully colored this component
//     }

//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] color = new int[n]; // Color array: -1 -> uncolored, 0 -> color1, 1 -> color2
//         Arrays.fill(color, -1);

//         // Convert the adjacency matrix to an adjacency list for convenience
//         List<List<Integer>> adjList = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<>());
//             for (int j : graph[i]) {
//                 adjList.get(i).add(j);
//             }
//         }

//         for (int i = 0; i < n; i++) {
//             if (color[i] == -1) { 
//                 // If the node is uncolored, start DFS from it
//                 if (!dfs(i, 0, adjList, color)) {
//                     return false; // If any component is not bipartite, return false
//                 }
//             }
//         }
//         return true; // All components are bipartite
//     }
// }


class Solution {
    public boolean isBipartite(int[][] adjList) {
        int n = adjList.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !isBipartite(i, adjList, colors, 0))
                return false;
        }
        return true;
    }
    boolean isBipartite (int i, int[][] adjList, int[] colors, int color) {
        if (colors[i] != -1)
            return colors[i] == color;
        colors[i] = color;
        for (int adjNode: adjList[i]) {
            if (!isBipartite(adjNode, adjList, colors, 1 - color))
                return false;
        }
        return true;
    }
}