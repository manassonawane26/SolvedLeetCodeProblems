class Solution {
    public int fib(int n) {
        if(n<2) return n;
        // if(n<3) return 1;
        return fib(n-1)+fib(n-2);
    }
}