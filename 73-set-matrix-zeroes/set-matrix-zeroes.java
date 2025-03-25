class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n = matrix[0].length;
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                    if(matrix[i][j] == 0){
                        iSet.add(i);
                        jSet.add(j);
                       
                    }
            }
        }

        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(iSet.contains(i) || jSet.contains(j)){
                    matrix[i][j]=0;
                } 
            }
        }
    }
}