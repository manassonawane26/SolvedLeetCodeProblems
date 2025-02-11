class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, sum=0;
        int rMax[] = new int[n];
        int cMax[] = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rMax[i]=Math.max(rMax[i], grid[i][j]);
                cMax[i]=Math.max(cMax[i], grid[j][i]);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = Math.min(rMax[i], cMax[j]);
                sum+=(temp - grid[i][j]);
            }
        }
        return sum;
    }
}