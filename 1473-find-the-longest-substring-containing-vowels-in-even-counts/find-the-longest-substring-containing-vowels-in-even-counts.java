import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int mask = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') mask ^= (1 << 0);
            else if (c == 'e') mask ^= (1 << 1);
            else if (c == 'i') mask ^= (1 << 2);
            else if (c == 'o') mask ^= (1 << 3);
            else if (c == 'u') mask ^= (1 << 4);
            
            if (m.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - m.get(mask));
            } else {
                m.put(mask, i);
            }
        }
        return maxLength;
    }
}

// class Solution {
//     public int findTheLongestSubstring(String s) {
//         int n = s.length();

//         // Now I'll create vowelMap<char, bitmask>
//         Map<Character, Integer> vowelMap = new HashMap<>();
//         vowelMap.put('a', 1 << 0);
//         vowelMap.put('e', 1 << 1);
//         vowelMap.put('i', 1 << 2);
//         vowelMap.put('o', 1 << 3);
//         vowelMap.put('u', 1 << 4);

//         // Another map to store bitmask position
//         Map<Integer, Integer> bitMap = new HashMap<>();
//         bitMap.put(0, -1);  // As we're computing maxLength

//         int maxLength = 0;

//         int prefixXor = 0;

//         // Here we just have to take care of even count of bitmask
//         for(int i = 0; i < n; i++) {
//             char ch = s.charAt(i);

//             // We'll only compute prefixXor of vowel
//             if(vowelMap.containsKey(ch)) {
//                 prefixXor ^= vowelMap.get(ch);
//             }

//             if(bitMap.containsKey(prefixXor)) {
//                 maxLength = Math.max(maxLength, i - bitMap.get(prefixXor));
//             } else {
//                 bitMap.put(prefixXor, i);
//             }
//         }

//         return maxLength;
//     }
// }