import java.util.HashMap;

public class shoppingOptions {
    /**
     * @param priceOfJeans
     * @param priceOfShoes
     * @param priceOfSkirts
     * @param priceOfTops
     * @return
     *
     *
     * Example
     * priceOfJeans = [2, 3]
     * priceOfShoes = [4]
     * priceOfSkirts = [2, 3]
     * priceOfTops = [1, 2]
     * budgeted = 10
     *
     */
    public static int getNumberOfOptions(int[] priceOfJeans, int[] priceOfShoes, int[] priceOfSkirts, int[] priceOfTops, int dollars){
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int jean : priceOfJeans){
            for (int shoe: priceOfShoes){
                map.put(shoe + jean, map.getOrDefault(shoe + jean, 0) + 1);
            }
        }
        for (int skirt : priceOfSkirts){
            for (int top : priceOfTops){
                int sum = top + skirt;
                for (int i = 0; i <= dollars - sum; i++) {
                    if (map.containsKey(i)){
                        res += map.get(i);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 3};
        int[] b = {4};
        int[] c = {2, 3};
        int[] d = {1, 2};
        System.out.println(getNumberOfOptions(a, b, c, d, 10));
    }
}
