class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, sum=0;
        int rMax[] = new int[n];
        int cMax[] = new int[n];
        for(int i=0; i<n; i++){
            int row=0, col=0;
            for(int j=0; j<n; j++){
                row=Math.max(row, grid[i][j]);
                col=Math.max(col, grid[j][i]);
                rMax[i]=row;
                cMax[i]=col;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum+=(Math.min(rMax[i], cMax[j]) - grid[i][j]);
            }
        }
        return sum;
    }
}