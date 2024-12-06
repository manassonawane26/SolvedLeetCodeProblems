class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> hs =  new HashSet<>();
        for(int i: banned)
            hs.add(i);
        int sum = 0;
        // int maxCount=0;
        int count = 0;
        for(int i=1;i<=n;i++){
            
            if(!hs.contains(i)){
                System.out.println(i);
                sum+=i;
                if(sum>maxSum){
                    // maxCount = Math.max(count, maxCount);
                    System.out.println("sum while exiting = " + sum );

                    break;
                } 
                count++;
                System.out.println("sum = " + sum );
                System.out.println("count = " + count );
            }
        }
        return count;
    }
}