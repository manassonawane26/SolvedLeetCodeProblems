class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)-> a.length() - b.length());
        HashMap<String, Integer> chainLen = new HashMap<>();
        int maxLen = 0;
        for (var word : words) {
            for (int indx = 0; indx < word.length(); indx++) {
                String pred = word.substring(0, indx) + word.substring(indx + 1);
                chainLen.put(word, Math.max(chainLen.getOrDefault(word, 0), (!chainLen.containsKey(pred)) ? 1 : chainLen.get(pred) + 1));
            }
            maxLen = Math.max(maxLen, chainLen.get(word));
        }
        return maxLen;
    }
}