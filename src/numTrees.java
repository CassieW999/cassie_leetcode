public class numTrees {
    public int numTrees(int n) {
        //1-n构成BST的方式由每一个数作为根的方式求和而知
        //即 C(n) = F(0) + F(1) + ... + F(n)
        //而 C(n) 的大小和内容无关，排列方式的数值仅和数量有关，所以这里的G(n)代表的是n个数组成的bst的总数
        int[] G = new int[n + 1];

        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                G[i] += G[i - 1] * G[j - i];
            }
        }
        return G[n];
    }
}
