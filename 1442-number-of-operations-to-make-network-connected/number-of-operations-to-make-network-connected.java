// class DisjointSet {
//     List<Integer> rank = new ArrayList<>();
//     List<Integer> parent =  new ArrayList<>();
//     public DisjointSet(int n){
//         for(int i = 0; i<n; i++){
//             rank.add(0);
//             parent.add(i);
//         }
//     }
//     public int findSuperParent(int n){
//         if(n==parent.get(n)) return n;
//         int superParent = findSuperParent(parent.get(n));
//         parent.set(n, superParent);
//         return parent.get(n);
//     }

//     public void unionFind(int u, int v){
//         if(rank.get(u) < rank.get(v)){
//             parent.set(u,v);
//         }
//         if(rank.get(u) > rank.get(v)){
//             parent.set(v,u);
//         }
//         else{
//             parent.set(v,u);
//             int rankU = rank.get(u);
//             rank.set(u, rank.get(u)+1);
//         }
//     }
// }
// class Solution {

//     public int makeConnected(int n, int[][] connections) {
//         DisjointSet ds = new DisjointSet(n);
//         int cnt = 0;
//         for(int[] i: connections){
//             int u = i[0];
//             int v = i[1];
//             if(ds.findSuperParent(u) == ds.findSuperParent(v)){
//                 cnt++;
//             }
//             ds.unionFind(u,v);
            
//         }
//         int CountComp = 0;
//         for(int j=0; j< n; j++)
//             if(ds.parent.get(j)==j)
//                 CountComp++;

//         System.out.println(cnt);
//         System.out.println(CountComp);   
//         if(cnt >= CountComp-1) return CountComp-1;
//         return -1;
//     }
// }

class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        while(parent[x]!=x){
            x = parent[parent[x]];
        }
        return x;
    }
    int makeUnion(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(parX == parY){
            return 0;
        }
        else if(rank[parX]<rank[parY]){
            parent[parX] = parY;
        }
        else if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }
        else{
            parent[parY] = parX;
            rank[parX]++;
        }
        return 1;
    }
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges<n-1){
            return -1;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int components = n;
        for(int[] con : connections){
            components -= makeUnion(con[0], con[1]);
        }
        return components-1;
    }
}