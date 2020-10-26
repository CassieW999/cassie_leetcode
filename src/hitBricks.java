public class hitBricks {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];

        // step-1
        for(int[] hit: hits) grid[hit[0]][hit[1]] -= 1;
        // step-2   mark all 1s to 2
        for(int j=0; j<grid[0].length; j++){
            if(grid[0][j] > 0) dfs(0, j, grid);  // O(N^2)
        }
        // step-3   O(N^2)
        for(int k=hits.length-1; k>-1; k--){
            int[] hit = hits[k];
            grid[hit[0]][hit[1]] += 1;
            if(grid[hit[0]][hit[1]] == 1 && check(hit[0], hit[1], grid)){
                res[k] = dfs(hit[0], hit[1], grid) - 1;
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid){
        if((i<0 || i>=grid.length) || (j<0 || j>=grid[0].length) || (grid[i][j] != 1)) return 0;
        grid[i][j] = 2;
        int cnt = 1;
        for(int[] nxt: new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) cnt += dfs(i+nxt[0], j+nxt[1], grid);
        return cnt;
    }

    private boolean check(int i, int j, int[][] grid){
        for(int[] nxt: new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0,-1}}){
            if((i+nxt[0]>=0 && i+nxt[0]<grid.length) && (j+nxt[1]>=0 && j+nxt[1]<grid[0].length) && grid[i+nxt[0]][j+nxt[1]] == 2) return true;
        }
        return i==0;
    }
}
