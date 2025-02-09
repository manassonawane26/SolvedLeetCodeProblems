// class Solution {
//     public int convertTime(String current, String correct) {
//         String curr[] = current.split(":");
//         String corr[] = correct.split(":");
//         int first = Integer.parseInt(curr[0]) * 60 + Integer.parseInt(curr[1]);
//         int second = Integer.parseInt(corr[0]) * 60 + Integer.parseInt(corr[1]);
//         int diff = Math.abs(first - second);
        
//         int ans = diff / 60;
//         diff = diff % 60;
        
//         ans += diff / 15;
//         diff = diff % 15;

//         ans += diff / 5;
//         diff = diff % 5;

//         ans += diff / 1;
//         diff = diff % 1;

//         return ans;
//     }
// }

class Solution {
    public int convertTime(String current, String correct) {
        int diff=min(correct)-min(current),arr[]={60,15,5,1},ans=0,i=0;
        while(diff>0){
            // int quotient=diff/arr[k];
            // diff-= (quotient*arr[k]);
            // ans+=quotient;
            // k++;
            ans+=diff / arr[i];
            diff = diff % arr[i++];
        }
        return ans;
    }
    static int min(String s){
        return (((s.charAt(0)-'0')*10 + (s.charAt(1)-'0'))*60) + ((s.charAt(3)-'0')*10 + (s.charAt(4)-'0'));
    }
}