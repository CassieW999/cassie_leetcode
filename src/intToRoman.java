public class intToRoman {
    public String intToRoman(int num) {
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val =     {1000,900, 500, 400,100, 90,  50, 40,  10,  9,  5,  4,  1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < val.length; i++){
            int x = num / val[i];
            num = num % val[i];
            if (x != 0){
                for (int j = 0; j < x; j++){
                    sb.append(roman[i]);
                }
            }
            if (num == 0) break;
        }
        return sb.toString();
    }
}


///////解题思路：时间复杂度O[n] 空间复杂度O[1]
///该题最重要的地方在于如何处理4 9 这样的值，在本解法中，将这些值也放入字典中就可以实现
///另外，这种字典的写法也需要借鉴，即两个数组用同一个索引来实现一一对应关系
