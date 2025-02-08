class Solution {
    // Inner class representing the Trie node
    class Trie {
        Trie[] child;  // Array to store child nodes for each character
        boolean eow;   // Boolean flag to indicate the end of a word
        int times;     // Counter to keep track of the number of times a word ends here

        // Constructor to initialize the Trie node
        public Trie() {
            child = new Trie[26];  // Initialize the array for 26 lowercase English letters
            eow = false;           // Initially, not the end of a word
            times = 0;             // Initially, no words end here
        }
    }

    // Method to insert a word into the Trie
    public void insert(Trie curr, String word) {
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';  // Calculate the index for the character
            if (curr.child[idx] == null) {
                curr.child[idx] = new Trie();  // Create a new Trie node if it doesn't exist
            }
            curr = curr.child[idx];  // Move to the child node
        }
        curr.eow = true;  // Mark the end of the word
        curr.times++;     // Increment the counter for the word
    }

    public int count = 0;  // Variable to keep track of the count of matching subsequences

    // Recursive method to search for subsequences in the Trie
    public void search(Trie curr, String word, int pos) {
        if (curr.eow == true) {
            count = count + curr.times;  // If at the end of a word, add the count of times
        }
        if (pos >= word.length()) {
            return;  // Return if the position is out of bounds
        }
        for (int i = 0; i < 26; i++) {
            if (curr.child[i] != null) {
                char ch = (char) (97 + i);  // Convert index to character
                for (int j = pos; j < word.length(); j++) {
                    if (ch == word.charAt(j)) {
                        search(curr.child[i], word, j + 1);  // Recursively search for the next character
                        break;
                    }
                }
            }
        }
    }

    // Main method to count the number of matching subsequences
    public int numMatchingSubseq(String s, String[] words) {
        Trie root = new Trie();  // Create the root of the Trie
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);  // Insert each word into the Trie
        }
        search(root, s, 0);  // Search for subsequences in the Trie
        return count;  // Return the count of matching subsequences
    }
}