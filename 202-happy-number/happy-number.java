class Solution {
    private int sq(int n){
        int ans = 0;
        while(n>0){
            int rem = n%10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = sq(slow);
            fast = sq(sq(fast));
        }
        while(slow!=fast);
        if(slow == 1){
            return true;
        }
        return false;
    }
}


/*
class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> hs=new HashSet<>();
        
        while(true){
            int sum=0;
            while(n>0){
                sum += Math.pow(n%10,2);
                n=n/10;
            }

            if(sum==1) return true;    
            if(hs.contains(sum)) return false;
             
            hs.add(sum);
            n=sum;
        }
    }
}
*/