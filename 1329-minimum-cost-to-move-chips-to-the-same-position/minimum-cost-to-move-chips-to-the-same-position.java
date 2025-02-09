class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCoins = 0;
        int oddCoins = 0;

        for (int i = 0; i < position.length; i++)
            if (position[i] % 2 == 0) evenCoins++;
            else oddCoins++;

        return Math.min(evenCoins, oddCoins);
    }
}