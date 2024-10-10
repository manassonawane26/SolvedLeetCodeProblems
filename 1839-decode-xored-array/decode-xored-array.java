class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length+1];
        int i=1;
        ans[0] = first;
        for(int num: encoded){
            ans[i++] = first^num;
            first = ans[i-1];
        }
        return ans;
    }
}