// DFS
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (i!=0) {
                    return false;
                }
                dfs(rooms, vis, i);
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, boolean[] vis, int u) {
        vis[u] = true;
        for (int v : rooms.get(u)) {
            if (!vis[v]) {
                dfs(rooms, vis, v);
            }
        }
    }
}