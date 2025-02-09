class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int min = 0;
        int max = n;
        int[] arr = new int[n+1];
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == 'I')
                arr[i] = min++;
            else arr[i] = max--;
        }
        arr[n] = min;
        return arr;
    }
}