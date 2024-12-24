class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<mat.length;i++){
            int sum=0;
            int left = 0, right = mat[i].length - 1;

            // Perform binary search to find the count of soldiers
            while (left <= right) {
                int mid = (left + right) / 2;
                if (mat[i][mid] == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sum = left;
            // for(int j=0;j<mat[0].length;j++){
            //     if(mat[i][j]==1){
            //         sum++;
            //     }
            //     else break;
            // }
            pq.add(sum*100+i);
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove()%100;
        }
        return ans;
    }
}