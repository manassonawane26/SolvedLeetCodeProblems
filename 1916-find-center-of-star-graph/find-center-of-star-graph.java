// class Solution {
//     public int findCenter(int[][] edges) {
//         int n = edges.length;
//         List<List<Integer>> adList = new ArrayList<>(n+1);
//         for(int i = 0; i<=n+1;i++)
//             adList.add(new ArrayList());
//         for(int i[] : edges){
//             adList.get(i[0]).add(i[1]);
//             adList.get(i[1]).add(i[0]);
//             if(adList.get(i[0]).size() == n)
//                 return adList.get(i[0]).get(0);
//             if(adList.get(i[1]).size() == n)
//                 return adList.get(i[1]).get(0);
//         }
//         return -1;
//     }
// }

class Solution {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}