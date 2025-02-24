class Solution {
    public Integer dp[][];
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        // if floor length is less than or equal to avaliable tiles return 0
        if(n <= numCarpets*carpetLen) return 0;
        
        //dp array
        dp = new Integer[n+1][numCarpets+1];
        
        //Prefix sum array for floor string
        int[] whiteTiles = new int[n+1];
        for(int i=1;i<=n;i++) {
            int curVal = floor.charAt(i-1)=='1' ? 1 : 0;
            whiteTiles[i] = whiteTiles[i-1] + curVal;
        }
        
        //finding maximum tiles we can cover with available numCarpets * carpetLen tiles
        int maxTilesCovered = maxTilesCanCover(whiteTiles, 1, numCarpets, carpetLen, n+1);
        
        // Subtracting all tiles which need to covered minus maximum no of tiles we were able to cover
        return whiteTiles[n] - maxTilesCovered;
    }
    public int maxTilesCanCover(int[] tiles , int ind, int numCarpets, int len, int n) {
        //base condition
        if(ind>=n || numCarpets<=0) return 0;
        
        //dp state to cache precomputed state
        if(dp[ind][numCarpets]!=null) return dp[ind][numCarpets];
        int ans = maxTilesCanCover(tiles, ind+1, numCarpets, len, n);
        
        //if the tile length is greater than array length taking the minimum of them
        int lastInd = Math.min(ind+len-1, n-1);
        
        // finding no of tiles present in the given tile length
        int curTileLen = tiles[lastInd]-tiles[ind-1];
        
        //Only computing when the current Tile length is less than or equal to available numCarpets * carpetLen tiles
        if(curTileLen<=(numCarpets*len)) {
            int noOfTilesReq = (int) Math.ceil((double) curTileLen/len);
            ans = Math.max(ans,curTileLen + maxTilesCanCover(tiles, lastInd+1, numCarpets-noOfTilesReq, len,n));
        }
        
        //Storing and returning the computed result
        return dp[ind][numCarpets]=ans;
    }
}