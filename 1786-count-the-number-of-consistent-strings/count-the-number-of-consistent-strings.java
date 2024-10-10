// class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
//         Set<Character> set= new HashSet<>();
//         int count=0;
//         for(int i=0;i<allowed.length();i++){
//             set.add(allowed.charAt(i));
//         }
//         for(String s:words){
//             int flag=1;
//             for(int i=0;i<s.length();i++){
//                 if(!set.contains(s.charAt(i))){
//                    flag = 0;
//                    break;
//                 }
//             }
//             if(flag==1)
//                 count++;
//         }
//         return count;
//     }
// }

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int freq = 0;
        for(char c : allowed.toCharArray()){
            freq=freq | 1<<(c-'a');
        }
        System.out.println(freq);
        int res = words.length;
        for(String word: words){
            for(char c : word.toCharArray()){
                if((freq & 1<<(c-'a'))==0){
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}