class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();

        // Now I'll create vowelMap<char, bitmask>
        Map<Character, Integer> vowelMap = new HashMap<>();
        vowelMap.put('a', 1 << 0);
        vowelMap.put('e', 1 << 1);
        vowelMap.put('i', 1 << 2);
        vowelMap.put('o', 1 << 3);
        vowelMap.put('u', 1 << 4);

        // Another map to store bitmask position
        Map<Integer, Integer> bitMap = new HashMap<>();
        bitMap.put(0, -1);  // As we're computing maxLength

        int maxLength = 0;

        int prefixXor = 0;

        // Here we just have to take care of even count of bitmask
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // We'll only compute prefixXor of vowel
            if(vowelMap.containsKey(ch)) {
                prefixXor ^= vowelMap.get(ch);
            }

            if(bitMap.containsKey(prefixXor)) {
                maxLength = Math.max(maxLength, i - bitMap.get(prefixXor));
            } else {
                bitMap.put(prefixXor, i);
            }
        }

        return maxLength;
    }
}