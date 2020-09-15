public class maximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int ans = 0;
        if(row<=0) return ans;
        int col = matrix[0].length;
        for(int i = 0; i<row; i++)  if(matrix[i][0]=='1') ans =1;
        if(ans<1) for(int j = 0; j<col; j++)  if(matrix[0][j]=='1') ans =1;
        for(int i = 1 ; i <row; i++){
            for(int j = 1;j<col; j++){
                int cur = matrix[i][j];
                if(cur!='0'){
                    int up = matrix[i-1][j] - '0';
                    int left = matrix[i][j-1] - '0';
                    int ul = matrix[i-1][j-1] - '0';
                    int temp =Math.min(up,Math.min(left,ul))+1;
                    ans = Math.max(ans,temp);
                    matrix[i][j] =(char)(temp +'0');
                }
            }
        }
        return ans*ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}


//////从这一题反映出来一个很重大的问题，即对数据结构的不熟悉。此处的体现为不了解char和int的相互转化是根据ASCII表来的，而非完全转换，因此理解上
///出了很大问题，需要好好补充知识。

////其次，动态规划问题最重要的一点就是找到状态转移方程，这个题目的状态转移方程为判断左、上、左上 三个点的最大状态值，随后得出该点的状态值，并不难
