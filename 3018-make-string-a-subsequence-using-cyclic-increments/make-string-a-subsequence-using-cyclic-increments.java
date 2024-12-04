// class Solution {
//     public boolean canMakeSubsequence(String source, String target) {
//         int targetIdx = 0, targetLen = target.length();
        
//         for (char currChar : source.toCharArray()) {
//             if (targetIdx < targetLen && (target.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
//                 targetIdx++;
//             }
//         }
//         return targetIdx == targetLen;
//     }
// }

class Solution {
    char lessChar(char ch) {
            return ch == 'a' ? 'z' : (char)(ch - 1);
        }
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;

        
        
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == lessChar(str2.charAt(j)) || str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            i++;
        }
        
        return j == str2.length();
    }
}