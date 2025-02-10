class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        for(int i = 0; i<s.length();){
            int startIdx = i;
            int endIdx = s.lastIndexOf(s.charAt(i));
            for(int j = startIdx+1; j<=endIdx-1; j++){
                int lastIdxOfNextChar = s.lastIndexOf(s.charAt(j));
                if(lastIdxOfNextChar > endIdx)
                    endIdx = lastIdxOfNextChar;
            }
            partitions.add(endIdx - startIdx + 1);
            i=endIdx+1;
        }
        return partitions;
    }
}