import java.util.*;

class Solution {
    //Function to know cur_bomb can explode the sur_bomb(current bomb, surounding bomb)
    public static boolean isPossible(int[] cur_bomb, int[] sur_bomb) {
        long cbx = cur_bomb[0];
        long cby = cur_bomb[1];
        long cbcap = cur_bomb[2];
        long sbx = sur_bomb[0];
        long sby = sur_bomb[1];
        return (cbx - sbx) * (cbx - sbx) + (cby - sby) * (cby - sby) <= cbcap*cbcap;
    }
    //helper function to get the ArrayList of surrounding bombs the current bomb can effect.
    public static ArrayList<Integer> helper(int[][] bombs, int cur) {
        ArrayList<Integer> indi_lst = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            if (i == cur) {
                continue;
            }
            if (isPossible(bombs[cur], bombs[i])) {
                indi_lst.add(i);
            }
        }
        return indi_lst;
    }
    //bfs to find the maximum number of bombs the current bomb can explode.
    public static int bfs(ArrayList<ArrayList<Integer>> lst, int i, boolean[] flag) {
        int res = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] cur_vis = new boolean[lst.size()];
        que.add(i);
        flag[i] = true;
        cur_vis[i]=true;
        res++;
        while (!que.isEmpty()) {
            int bmb = que.poll();
            for (int tmp : lst.get(bmb)) {
                if (!cur_vis[tmp]) {
                    que.add(tmp);
                    res++;
                    cur_vis[tmp] = true;
                    flag[tmp] = true;
                }
            }
        }
        return res;
    }
    //main function
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lst.add(helper(bombs, i));
        }
        int res = 0;
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                res = Math.max(res, bfs(lst, i, flag));
            }
        }
        // System.out.println(lst);
        return res;
    }
}