// class Solution {
//     public int numTilePossibilities(String tiles) {
//         Set<String> set = new HashSet<>();
//         boolean[] vis = new boolean[tiles.length()];
//         permute(tiles, "", set, vis);
//         return set.size()-1;
//     }
//     public void permute(String tiles, String curr, Set<String> set, boolean[] vis){
//         set.add(curr);
//         for(int i =0; i<tiles.length(); i++){
//             if(!vis[i]){
//                 vis[i] = true;
//                 permute(tiles, curr+tiles.charAt(i), set, vis);
//                 vis[i]=false;
//             }
//         }
//     }
// }

class Solution {
    public int helper(StringBuilder s){
        if(s.length() == 1)
            return 2;
        
        int count = 1;
        int[] freq = new int[26];
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(freq[c-'A'] == 0){
                freq[c-'A'] = 1;
                // char x = s.charAt(i);
                s.deleteCharAt(i);
                count += helper(s);
                s.insert(i, c);
            }
        }
        return count;
    }

    public int numTilePossibilities(String tiles) {
        return helper(new StringBuilder(tiles))-1;
    }
}