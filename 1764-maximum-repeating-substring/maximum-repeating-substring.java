// class Solution {
//     public int maxRepeating(String sequence, String word) {
//         int i=sequence.indexOf(word), n=sequence.length(), iPrev=0;
//         int count=1;
//         while(i<n && i>=0){
//             i = sequence.substring(i).indexOf(word);
//             System.out.println("i= "+ i);
//             i = i>=0? i+word.length()+ iPrev:i;
//             iPrev = i;
//             System.out.println("i + word length= "+ i);
//             count++;
//             System.out.println("count= "+ count);
//             // sequence.substring(i,n).indexOf(word);
            
//         }
//         return count;
//     }
// }


class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        str.append(word);
        while(sequence.contains(str) == true) {
            count++;
            str.append(word);
        }
        return count;
    }
}