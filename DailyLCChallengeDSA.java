class Solution {
    /*On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1. */
    private final int[][] options = {
            {1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}
        };
    public int slidingPuzzle(int[][] board) {
        
        
        StringBuilder sb = new StringBuilder();
        int zeroInd=0;
        for(int[] row:board){
            for(int val:row){
               sb.append(val);
                if(val==0){
                    zeroInd = val;
                }
                zeroInd++;
            }
        }
        Map<String, Integer> mp = new HashMap<>();
        int cnt = 0;
        sol(mp, sb.toString().indexOf("0"), sb.toString(), cnt);
        return mp.getOrDefault("123450",-1);
    }
    private void sol(Map<String,Integer> mp, int zeroInd, String state, int cnt){
        if(mp.containsKey(state) && mp.get(state)<=cnt){
            return;
        }
        mp.put(state, cnt);
        for(int op:options[zeroInd]){
            String newState = swap(op, zeroInd, state);
            sol(mp, op, newState, cnt+1);
        }
        
    }
    
    private String swap(int op, int zeroInd, String state){
        StringBuilder sb = new StringBuilder(state);
        //char c=sb.charAt(op);
        sb.setCharAt(op, state.charAt(zeroInd));
        sb.setCharAt(zeroInd, state.charAt(op));
        return sb.toString();
    }
    
}