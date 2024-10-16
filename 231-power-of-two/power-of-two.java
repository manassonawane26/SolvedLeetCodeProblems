class Solution {
    int x=1;
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        return (n%2 == 0) && isPowerOfTwo(n>>1);
    }
}