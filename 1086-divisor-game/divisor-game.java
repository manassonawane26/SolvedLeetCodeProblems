class Solution {
    public boolean divisorGame(int n) {
        int[] arr = new int[1005];
        arr[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j = 1; j*j<=i; j++)
                if(i%j == 0 && arr[i-j]==0) arr[i] = 1;
        }
        if(arr[n]==1)   return true;
        return false;
    }
}