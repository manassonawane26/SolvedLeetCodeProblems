class Solution {
    // public List<List<Integer>> generate(int n) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int i = 1; i<=n; i++){
    //         List<Integer> list = new ArrayList<>();
    //         list.add(1);
    //         int temp = 1;
    //         for(int j=1; j<i; j++){
    //             temp = temp * (i-j);
    //             temp = temp / j;
    //             list.add(temp);
    //         }
    //         ans.add(list);
            
    //     }
    //     return ans;
    // }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for(int i = 1; i<n; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int temp = 1;
            for(int j=1; j<i; j++){
                list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            list.add(1);
            ans.add(list);
            
        }
        return ans;
    }
}