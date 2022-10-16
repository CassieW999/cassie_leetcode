//public class fitWithCellReplacements {
//    public int[] fitWithCellReplacements(int[][] source, int[][] figure, int k){
//        //TODO:clarification
//        int m = source.length, n = source[0].length;
//        int a = figure.length, b = figure[0].length;
//        //TODO 算出source中总共有多少个障碍物 num_x 多少个空格
//        for (int i = 0; i <= m - a; i++) {
//            for (int j = 0; j <= n - b; j++) {
//                if (canFitIn(source, figure, i, j, k)){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
//
//    public boolean canFitIn(int[][] source, int[][] figure, int i, int j, int k) {
//        // 找出[i, j]为左上角的和figure同大小的窗口里 所有的障碍物 做成一个list
//        // 1。如果list长度大于k，返回false
//        // 2。如果list长度小于k，且外围还有足够的空格放障碍物，则返回true
//    }
//}
