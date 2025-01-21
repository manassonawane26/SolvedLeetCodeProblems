// DFS
// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int n = rooms.size();
//         boolean[] vis = new boolean[n];

//         for (int i = 0; i < n; i++) {
//             if (!vis[i]) {
//                 if (i!=0) {
//                     return false;
//                 }
//                 dfs(rooms, vis, i);
//             }
//         }
//         return true;
//     }
//     public void dfs(List<List<Integer>> rooms, boolean[] vis, int u) {
//         vis[u] = true;
//         for (int v : rooms.get(u)) {
//             if (!vis[v]) {
//                 dfs(rooms, vis, v);
//             }
//         }
//     }
// }

//BFS 1
// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int n = rooms.size();
//         Set vis = new HashSet<>();
//         Queue<Integer> q = new LinkedList<>();
//         q.add(0);
//         vis.add(0);
//         int count = 1;
//         while(!q.isEmpty()){
//             int curr = q.poll();
//             for(int i: rooms.get(curr)){
//                 if(!vis.contains(i)){
//                     q.offer(i);
//                     vis.add(i);
//                     count++;
//                     System.out.println(i);
//                 }
//             }
//         }
//         return vis.size() == n;
//     }
// }

//BFS2
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        vis[0] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            for (int key : rooms.get(currentRoom)) {
                if (!vis[key]) {
                    stack.push(key);
                    vis[key] = true;
                    count++;
                }
            }
        }
        return count == n;
    }
}