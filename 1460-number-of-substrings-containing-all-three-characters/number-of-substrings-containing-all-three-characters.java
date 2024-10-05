class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        Arrays.fill(hash,-1);
        int count = 0;

        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i) - 'a'] = i;
            int start = Integer.MAX_VALUE;

            for(int j=0; j<3; j++){
                // if(hash[j] == -1) continue;
                start = Math.min(start,hash[j]);
            }

            if(start == -1) continue;
            count += start+1;
        }
        return count;
    }
}