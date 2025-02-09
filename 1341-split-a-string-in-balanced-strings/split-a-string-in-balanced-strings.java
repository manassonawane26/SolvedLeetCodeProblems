class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int check = 0;
        for(char c: s.toCharArray()){
            if(c == 'R') 
                check++;
            else
                check--;

            if(check==0)
                count++;
        }
        return count;
    }
}