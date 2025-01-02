class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m =matrix[0].length;
        int l = matrix[0][0], r= matrix[n-1][m-1];
        while(l<=r){
            int mid = l + (r-l)/2;
            int count = countOfSamllerElement(matrix, mid);
            if(count >= k) r = mid-1;
            else l = mid + 1;
        }
        return l;
    }
    private int countOfSamllerElement(int[][] matrix, int val){
        int n = matrix.length, count=0;
        for(int i = 0 ; i < n; i++){
            int l = 0, r= matrix[i].length - 1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(matrix[i][mid] > val) r = mid-1;
                else l = mid + 1;
            }
            count += l;
        }
        return count;
    }
}


// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         int n = matrix.length, m = matrix[0].length;
//         if(k == 1) return matrix[0][0];
//         if(k == n*n) return matrix[n-1][n-1];
//         int l = matrix[0][0], r = matrix[n-1][m-1];
//         while(l<=r){
//             int mid = l + (r-l)/2;
//             int count = countOfSmallerOrEqualElements(matrix, mid);
//             if(count >= k) r = mid-1;
//             else l = mid + 1;
//         }
//         return l;
//     }
//     private int countOfSmallerOrEqualElements(int[][] matrix, int val){
//         int n = matrix.length;
//         int count = 0;
//         for(int i=0;i<n;i++){
//             int start= 0, end = n-1;
//             while(start<=end){
//                 int mid = start + (end-start)/2;
//                 if(matrix[i][mid] <= val)   start = mid + 1;
//                 else end = mid - 1;
//             }
//             count += start;
//         }
//         return count;
//     }
// }