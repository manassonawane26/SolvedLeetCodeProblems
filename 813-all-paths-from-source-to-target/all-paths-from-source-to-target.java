class Solution {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public List<List<Integer>> result = new ArrayList<>();

    public void allPath(ArrayList<Edge>[] graph, List<Integer> list, int curr, int tar, boolean[] vis) {
        if (curr == tar) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                list.add(e.dest);
                vis[e.dest] = true;
                allPath(graph, list, e.dest, tar, vis);
                vis[e.dest] = false;
                list.remove(list.size() - 1); 
            }
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] arr) {
        ArrayList<Edge>[] graph = new ArrayList[arr.length];
        for (int i = 0; i < arr.length; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                graph[i].add(new Edge(i, arr[i][j]));
            }
        }
        boolean[] vis = new boolean[arr.length];
        List<Integer> initialList = new ArrayList<>();
        initialList.add(0);
        vis[0] = true;
        allPath(graph, initialList, 0, arr.length - 1, vis);
        return result;
    }
}