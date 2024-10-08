class Solution {
    public int minSwaps(String s) {
        int close=0, maxClose=0;
        for(char c : s.toCharArray()){
            if(c=='[') close--;
            else close++;
            maxClose=Math.max(maxClose, close);
        }
        return (maxClose+1)/2;
    }
}