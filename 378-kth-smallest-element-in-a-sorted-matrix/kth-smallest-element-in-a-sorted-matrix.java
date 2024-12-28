class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        if(k == 1) return matrix[0][0];
        if(k == n*n) return matrix[n-1][n-1];
        int l = matrix[0][0], r = matrix[n-1][m-1];
        //int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int count = countOfSmallerOrEqualElements(matrix, mid);
            if(count >= k) {
                r = mid-1;
                //ans = mid;
            }
            else l = mid + 1;
        }
        return l;
    }
    private int countOfSmallerOrEqualElements(int[][] matrix, int val){
        int n = matrix.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int start= 0, end = n-1;
            while(start<=end){
                int mid = start + (end-start)/2;
                if(matrix[i][mid] <= val)   start = mid + 1;
                else end = mid - 1;
            }
            count += start;
        }
        return count;
    }
}

// int noOfSmallerElements = 0;
//         // int noOfSmallerElements = 0;
//         // for(int i=0;i<matrix.length;i++){
//             int start = 0;
//             int end = matrix[i].length-1;
//             while (start<=end){
//                 int mid = start + (end-start)/2;
//                 if(matrix[i][mid] <= assumedMedian){
//                     start = mid+1;
//                 } else {
//                     end = mid-1;
//                 }
//             }
//             // start.
//             noOfSmallerElements += start;
//         }
//         return noOfSmallerElements;