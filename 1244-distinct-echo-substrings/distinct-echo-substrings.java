// class Solution {
//     public int distinctEchoSubstrings(String text) {
//         int n = text.length();
//         HashSet<String> set = new HashSet<>();
//         for(int len = 1; len<=n/2; len++){
//             int count = 0;
//             for(int l=0, r=len; r<n; l++, r++){
//                 if(text.charAt(l)== text.charAt(r))
//                     count++;
//                 else
//                     count=0;

//                 if(count==len){
//                     String str = text.substring(l, r+1);
//                     set.add(str);
//                     count--;
//                 }
//             }
//         }
//         return set.size();
//     }
// }

class Solution {
    public int distinctEchoSubstrings(String text) {
        HashSet<String> set = new HashSet<>() ;
        for(int len = 1 ; len <= text.length()/2 ; len++) {
            for(int left = 0, right = len , count = 0 ; left < text.length() - len ; left++, right++) {
                if (text.charAt(left) == text.charAt(right)) count++;
			    else count = 0;

                if(count == len) {
                    set.add(text.substring(left - len +1 , left +1 )) ;
                    count -- ;
                }
            }
        }

        return set.size();
    }
}