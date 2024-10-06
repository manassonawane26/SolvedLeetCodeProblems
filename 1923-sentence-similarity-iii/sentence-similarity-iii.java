class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        String[]  str1= sentence1.split(" ");
        String[]  str2= sentence2.split(" ");
        int str1StartIdx = 0, str1EndIdx= str1.length-1;
        int str2StartIdx = 0, str2EndIdx= str2.length-1;

        while(str1StartIdx <= str1EndIdx && str2StartIdx <= str2EndIdx && str1[str1StartIdx].equals(str2[str2StartIdx])){
            str1StartIdx++;
            str2StartIdx++;
        }

        while(str1EndIdx >= str1StartIdx && str2EndIdx >= str2StartIdx && str1[str1EndIdx].equals(str2[str2EndIdx])){
            str1EndIdx--;
            str2EndIdx--;
        }
        return str1EndIdx < str1StartIdx || str2EndIdx < str2StartIdx;
    }
}