class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(matrix[0][0]);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i==0 && j==0) continue;
                if(i==0) matrix[i][j] ^= matrix[i][j-1];
                else if(j==0) matrix[i][j] ^= matrix[i-1][j];
                else matrix[i][j] ^= matrix[i][j-1] ^ matrix[i-1][j] ^ matrix[i-1][j-1];

                if(pq.size() == k){
                    if(matrix[i][j] > pq.peek()){
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
                else pq.offer(matrix[i][j]);
            }
        }
        return pq.poll();
    }
}