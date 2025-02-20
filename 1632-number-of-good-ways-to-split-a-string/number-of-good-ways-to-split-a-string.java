class Solution {
        public int numSplits(String s) {
        char[] chars = s.toCharArray();
        int one[] = new int[26], two[] =  new int[26];
        int distOne = 0, distTwo=0, cnt=0,cur;
        for(char c: chars) if(one[c-'a']++ ==0) distOne++;
        
        for(char c: chars) {
            cur = c-'a';
            if(--one[cur]==0) distOne--;
            if(two[cur]++==0) distTwo++;
            if(distOne==distTwo)  cnt++;
        }
        
        return cnt;
    }
}