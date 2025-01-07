class Solution{
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        int max = Integer.MIN_VALUE;
        for(int[] point : points) {
            while(!maxHeap.isEmpty() && point[0] - maxHeap.peek().getValue() > k) {
                maxHeap.poll();
            }
            if(!maxHeap.isEmpty()) {
                max = Math.max(max, point[0] + point[1] + maxHeap.peek().getKey());
            }
            maxHeap.offer(new Pair<Integer, Integer>(point[1] - point[0], point[0]));
        }
        return max;
    }
}

// class Solution {
//     public int findMaxValueOfEquation(int[][] points, int k) {
//         int max = Integer.MIN_VALUE; //assign the lowest number
//         int res = 0;
//         int mod = 0;
//         int flag = 1;
//         for(int i = 0;i<points.length-1;i++) //iteration over the points
//         {
//             if(flag<i+1)
//                 flag = i+1;
//             for(int j = flag;j<points.length;j++) 
// 			//iteration over the points again so that we can deliver the variables in the equation
//             {
//                 mod = points[j][0]-points[i][0]; 
//                 // if(mod<0)
//                 //     mod = -mod;
//                 if(mod>k)
//                     break;
//                 res = points[i][1]+points[j][1]+mod; //final equation 
//                 if(max<res)
//                 {
//                     max = res; //updation of max
//                     flag = j-1;
//                 }
//             }
//         }
//         return max;
//     }
    
// }