// class Solution {
//     public void reverseString(char[] s) {
//         reverse(s, 0);
//     }
//     void reverse(char[] s, int i){
//         int n=s.length;
//         if(i==n/2) return;
//         char temp=s[i];
//         s[i]=s[n-i-1];
//         s[n-i-1]=temp;
//         reverse(s, i+1);
//     }
// }


class Solution {
    public void reverseString(char[] s) {
        int left = 0,right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right--] = s[left];
            s[left++] = temp;
        }
    }
}