class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0, j = 0, res = 0, trueCount = 0, falseCount=0;
        while(j < answerKey.length()) {
            if(answerKey.charAt(j) == 'T') {
                trueCount++;
            } else {
                falseCount++;
            }
            while(trueCount > k && falseCount > k) {
                if(answerKey.charAt(i) == 'T') {
                    trueCount--;
                } else {
                    falseCount--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}