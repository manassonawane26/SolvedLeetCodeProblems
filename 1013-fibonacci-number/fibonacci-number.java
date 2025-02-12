class Solution {
    public int fib(int n) {
        int[] fibo = new int[n+1];
        return recursion(n, fibo);
    }
    int recursion(int n, int[] fibo){
        if(fibo[n] > 0) return fibo[n];
        if(n<2) return n;

        // if(n<3) return 1;
        fibo[n]=recursion(n-1, fibo) + recursion(n-2, fibo);
        return fibo[n];
    }
}