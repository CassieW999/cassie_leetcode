public class decodeString {
    private static int numIndex = 0;//记录递归中 for循环中i的位置
    public String decodeString(String s) {
        if (s.length()==0)
            return "";
        char[] chars = s.toCharArray();
        return invoke(chars,0);
    }

    public String invoke(char[] s, int index){
        StringBuilder sb = new StringBuilder();//记录每次递归中得到的字符串
        StringBuilder num = new StringBuilder();//记录每次递归前的字符串重复次数
        for (int i = index; i < s.length; i++) {
            if ((s[i]>='a'&&s[i]<='z') || (s[i]>='A'&&s[i]<='Z')){
                sb.append(s[i]);
            }else if (s[i] >='0'&&s[i]<='9') {
                num.append(s[i]);
                //如果是 "[" 这个符号说明，数字已经记录完整，要开始递归进入了
            }else if(s[i] == '['){
                String invoke = invoke(s, i + 1);
                //所以接下来的操作就是拼接字符串，之前保存的数字就是要循环的次数
                for (int j = 0; j < Integer.parseInt(num.toString()); j++) {
                    sb.append(invoke);
                }
                //清楚之前保存的数字
                num.setLength(0);
                //设置i的值，因为递归，所以numIndex之前的字符都分析过了，下次循环就直接跳过就行
                i = numIndex;
                //如果是 "]" 这个符号说明要结束递归了，因为子结构分析完了，要返回数据
            }else if (s[i] == ']'){
                numIndex = i;//记录这次递归 i到达的位置
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
