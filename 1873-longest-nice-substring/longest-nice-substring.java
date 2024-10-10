class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        // char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) set.add(c);
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            if (!set.contains(c) || !set.contains(Character.toLowerCase(c))) {
                String sub1 = longestNiceSubstring(s.substring(0, i));
                String sub2 = longestNiceSubstring(s.substring(i+1));
                return sub1.length() >= sub2.length() ? sub1 : sub2;
            }
        }
        return s; 
    }
}