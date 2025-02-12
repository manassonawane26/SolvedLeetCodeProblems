class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        return recursion(n, fibo);

    }
    int recursion(int n, int[] fibo){
        if(fibo[n] > 0) return fibo[n];
        if(n<=2) return n;

        // if(n<3) return 1;
        fibo[n]=recursion(n-1, fibo) + recursion(n-2, fibo) + recursion(n-3, fibo);
        return fibo[n];
    }
}