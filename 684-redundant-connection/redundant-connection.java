// class Solution {
//     int root[], size[];

//     public int findParent(int node) {
//         if (node == root[node])
//             return node;
//         return root[node] = findParent(root[node]);
//     }

//     public boolean union(int u, int v) {
//         int rootU = findParent(u);
//         int rootV = findParent(v);
//         if (rootV == rootU)
//             return false;
//         else if (size[rootU] > size[rootV]) {
//             size[rootU] += size[rootV];
//             root[rootV] = rootU;
//         } else {
//             size[rootV] += size[rootU];
//             root[rootU] = rootV;
//         }
//         return true;
//     }

//     public int[] findRedundantConnection(int[][] edges) {
//         int n = edges.length, k = 0;
//         root = new int[n + 1];
//         size = new int[n + 1];
//         Arrays.fill(size, 1);
//         for (int i = 0; i <= n; i++)
//             root[i] = i;
//         for (int[] edge : edges) {
//             if (!union(edge[0], edge[1]))
//                 break;
//             k++;
//         }
//         return new int[] { edges[k][0], edges[k][1] };
//     }
// }

class Solution {
    int root[], rank[];

    public int findParent(int node) {
        if (node == root[node])
            return node;
        return root[node] = findParent(root[node]);
    }

    public boolean union(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootV == rootU){
            // root[rootV] = rootU;
            // rank[rootU] = rank[rootU]+1;
            return false;
        }
        else if (rank[rootU] > rank[rootV]) {
            root[rootV] = rootU;
        } else {
            root[rootU] = rootV;
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length, k = 0;
        root = new int[n + 1];
        rank = new int[n + 1];
        Arrays.fill(rank, 1);
        for (int i = 0; i <= n; i++)
            root[i] = i;
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1]))
                break;
            k++;
        }
        return new int[] { edges[k][0], edges[k][1] };
    }
}