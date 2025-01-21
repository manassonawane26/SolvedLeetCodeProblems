//DFS
// class Solution {
//     public int findCircleNum(int[][] grid) {
//         int n = grid.length;
//         boolean[] vis = new boolean[n];

//         int count=0;
//         for (int i = 0; i < n; i++) {
//             if (!vis[i]) {
//                 dfs(grid, vis, i);
//                 count++;
//             }
//         }

//         return count;
//     }
    
//     public void dfs(int[][] grid, boolean[] vis, int u) {
//         vis[u] = true;
//         for (int v = 0; v < grid.length; v++) {
//             if (grid[u][v]==1) {
//                 if (!vis[v]) {
//                     dfs(grid, vis, v);
//                 }
//             }
//         }
//     }

// }

//BFS
class Solution {
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        boolean[] vis = new boolean[n];

        int count=0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(grid, vis, i);
                count++;
            }
        }

        return count;
    }
    
    public void bfs(int[][] grid, boolean[] vis, int U) {
        Queue<Integer> q = new LinkedList<>();

        vis[U] = true;
        q.add(U);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < grid.length; v++) {
                if (grid[u][v]==1) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.add(v);
                    }
                }   
            }
        }
    }

}