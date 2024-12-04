// class Solution {
//     public String reorganizeString(String s) {
//         HashMap<Character, Integer> freqMap = new HashMap<>();
//         for(char c: s.toCharArray())
//             freqMap.put(c,freqMap.getOrDefault(c,0)+1);

//         PriorityQueue<Character> mh = new PriorityQueue<>((a,b) -> freqMap.get(b)-freqMap.get(a));
//         mh.addAll(freqMap.keySet());

//         StringBuilder sb = new StringBuilder();
//         while(mh.size() > 1){
//             char ch1 = mh.poll();
//             char ch2 = mh.poll();

//             sb.append(ch1);
//             sb.append(ch2);
            
//             freqMap.put(ch1, freqMap.get(ch1) -1);
//             freqMap.put(ch2, freqMap.get(ch2) -1);

//             if(freqMap.get(ch1) > 0) mh.offer(ch1);
//             if(freqMap.get(ch1) > 0) mh.offer(ch2);
//         }
//         if(!mh.isEmpty()){
//             char ch = mh.poll();
//             if(freqMap.get(ch) > 1) return "";
//             sb.append(ch);
//         }
//         return sb.toString();
//     }
// }


public class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        if (freqMap.get(maxHeap.peek()) > (s.length() + 1) / 2) {
            return "";
        }

        // StringBuilder res = new StringBuilder();
        char[] result = new char[s.length()];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for (int j = 0; j < freqMap.get(c); j++) {
                if (i >= s.length()) i = 1;
                result[i] = c;
                i += 2;
            }
        }

        return new String(result);
    }
}