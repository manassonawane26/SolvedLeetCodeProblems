class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0 ; i < n; i ++){
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int j = 0 ; j < n ; j ++){
                hs.add(matrix[i][j]);
            }
            if(hs.size() != n){
                return false;
            }
        }
        for(int i = 0 ; i < n; i ++){
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int j = 0 ; j < n ; j ++){
                hs.add(matrix[j][i]);
            }
            if(hs.size() != n){
                return false;
            }
        }
        return true;
    }
}
// class Solution {
//     public boolean checkValid(int[][] matrix) {
//         for(int[] arr: matrix){
//             int one=0, two=0, three=0;
//             for(int num: arr){
//                 if(num == 1) one++;
//                 else if (num == 2) two++;
//                 else if (num == 3) three++;
//             }
//             if(one!=1 || two!=1 || three!=1) return false;
//         }
//         return true;
//     }
// }