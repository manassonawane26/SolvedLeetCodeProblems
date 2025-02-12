class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int temp = 1;
            for(int j=1; j<i; j++){
                temp = temp * (i-j);
                temp = temp / j;
                list.add(temp);
            }
            ans.add(list);
            
        }
        return ans;
    }
}