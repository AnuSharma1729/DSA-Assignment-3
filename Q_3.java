class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max =0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < grid.length; ++i){
            for(int j= 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    List<Integer> comp = new ArrayList<>();
                    solve(grid,i,j,dirs,comp);
                    max  = Math.max(max,comp.size());
                }
            }
        }
        return max;
    }
    
    public void solve(int[][] grid, int i, int j, int[][] dirs, List<Integer> comp){
        
        grid[i][j] = 0;
        comp.add(1);
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r < 0 || c < 0 || r >= grid.length || c>= grid[0].length || grid[r][c] == 0) continue;
            solve(grid,r,c,dirs,comp);
        }
    }
}
