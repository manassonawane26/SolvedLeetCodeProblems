class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Convert the adjacency matrix to an adjacency list for convenience
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for (int i=0; i<n; i ++ ){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int indegree[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int it: adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0)
                q.add(i);
        }

        int[] topo = new int[numCourses];
        int idx = 0; // numCourses-1;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[idx++] = node;
            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(idx == numCourses) return topo;
        return new int[] {};
    }
}