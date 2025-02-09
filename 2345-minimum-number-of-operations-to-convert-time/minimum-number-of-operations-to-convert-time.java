class Solution {
    public int convertTime(String current, String correct) {
        String curr[] = current.split(":");
        String corr[] = correct.split(":");
        int first = Integer.parseInt(curr[0]) * 60 + Integer.parseInt(curr[1]);
        int second = Integer.parseInt(corr[0]) * 60 + Integer.parseInt(corr[1]);
        int diff = Math.abs(first - second);
        
        int ans = diff / 60;
        diff = diff % 60;
        
        ans += diff / 15;
        diff = diff % 15;

        ans += diff / 5;
        diff = diff % 5;

        ans += diff / 1;
        diff = diff % 1;

        return ans;
    }
}