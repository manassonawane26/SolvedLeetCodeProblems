class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    sum++;
                }
                else break;
            }
            pq.add(sum*100+i);
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove()%100;
        }
        return ans;
    }
}