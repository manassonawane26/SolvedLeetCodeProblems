// class Solution {
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         List<List<Integer>> ans = new ArrayList<>();
//         findPath(0, graph, ans, new ArrayList<>());
//         return ans;
//     }
//     private void findPath(int node, int[][] graph, List<List<Integer>> ans, List<Integer> curr){
//         curr.add(node);
//         if(node == graph.length -1){
//             ans.add(new ArrayList<>(curr));
//             curr.remove(curr.size()-1);
//             return;
//         }

//         for(int i: graph[node]){
//             findPath(i, graph, ans, curr);
//         }
//         curr.remove(curr.size()-1);
//     }
// }

class Solution {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), graph, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> path, int[][] graph, int n) {
        path.add(n);
        if(n == graph.length-1)
            result.add(new ArrayList<>(path));
        else{
            for(int v: graph[n])
                backtrack(result, path, graph, v);
        }
        path.remove(path.size() -1);
    }
}

// class Solution {

//     public void backtrack(List<List<Integer>> result, List<Integer> path, int[][] graph, int n) {
//         path.add(n);

//         if(n == graph.length - 1)
//             result.add(new ArrayList<>(path));
//         else 
//             for(int v : graph[n]) 
//                 backtrack(result, path, graph, v);

//         path.remove(path.size() -1);
//     }
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         List<List<Integer>>  result = new ArrayList<>();
//         backtrack(result, new ArrayList<>(), graph, 0);

//         return result;
//     }
// }