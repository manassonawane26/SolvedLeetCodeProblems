class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int i=0;
        int j=n-1;
        while(i<n){
            if(colors[i]==colors[n-1]){
                i++;
            }
            else return n-1-i;
            if(colors[j]==colors[0]){
                j--;
            }
            else return j;
        }
        return -1;
    }
}