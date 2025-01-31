class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int len = dislikes.length;
        boolean[] check = new boolean[len];
        int[] arr = new int[n + 1];
        boolean foundNew;
        for(int i = 0; i < len; i++){
            if(check[i]) continue;
            arr[dislikes[i][0]] = 1;
            arr[dislikes[i][1]] = 2;
            foundNew = true;
            while(foundNew){
                foundNew = false;
                for(int j = i + 1; j < len; j++){
                   if(check[j]) continue;
                   int x = arr[dislikes[j][0]], y = arr[dislikes[j][1]];
                   if(x == 0 && y == 0) continue;
                   if(x > 0 && y > 0){
                       if((x - y) % 2 == 0) return false;
                   } 
                   else if(x > 0) arr[dislikes[j][1]] = x + 1;
                   else arr[dislikes[j][0]] = y + 1;
                   foundNew = true;
                   check[j] = true;
                } 
            }
        }
        return true;
    }
}