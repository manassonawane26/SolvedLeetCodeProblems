// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<String>();
//         recurse(res, 0, 0, "", n);
//         return res;
//     }
    
//     public void recurse(List<String> res, int left, int right, String s, int n) {
//         if (s.length() == n * 2) {
//             res.add(s);
//             return;
//         }
        
//         if (left < n) {
//             recurse(res, left + 1, right, s + "(", n);
//         }
        
//         if (right < left) {
//             recurse(res, left, right + 1, s + ")", n);
//         }
//     }
// 	// See above tree diagram with parameters (left, right, s) for better understanding
// }


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genParanthesisHelper(res,new StringBuilder(),n,n);
        return res;
    }

    private void genParanthesisHelper(List<String> res,StringBuilder sb,int open,int close){
        if(close < open) return;
        if(close == 0 && open == 0){
            res.add(sb.toString());
        }
       
        if(open > 0){
            sb.append("(");
            genParanthesisHelper(res,sb,open-1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close > 0){
            sb.append(")");
            genParanthesisHelper(res,sb,open,close-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}