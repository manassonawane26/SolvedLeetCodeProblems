class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int count=0;
        for(String s:sentence.split(" ")){
            if(s.indexOf(searchWord)==0){
                return count+1;
            }
            count++;
        }
        return -1;
    }
}