public class freshPromotion {
    /**
     *
     * @param codeList
     * @param shoppingCart
     * @return
     *
     * Example 1:
     * codeList = [[apple, apple], [banana, anything, banana]]
     * shoppingCart = [orange, apple, apple, banana, orange, banana]
     */
    public static boolean isWinner(String[][] codeList, String[] shoppingCart){
        int index = 0;
        int codeIndex = 0;
        while (index < shoppingCart.length && codeIndex < codeList.length){
            String cur = shoppingCart[index];
            if ((cur.equals(codeList[codeIndex][0]) || codeList[codeIndex][0].equals("anything")) && isMatch(shoppingCart, index, codeList[codeIndex])){
                index += codeList[codeIndex++].length;
            }else{
                index++;
            }
        }
        return codeIndex == codeList.length ? true : false;
    }

    private static boolean isMatch(String[] shoppingCart, int idx, String[] order) {
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
