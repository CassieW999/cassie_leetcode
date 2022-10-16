//
//
//public class depthSumInverse {
//    int sum = 0;
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        dfs(nestedList, 0, 1, nestedList.size());
//        return sum;
//    }
//
//    public void dfs(List<NestedInteger> nestedList, int idx, int weight, int len){
//        if (idx == len) return;
//
//        if (nestedList.get(idx).isInteger()){
//            sum += nestedList.get(idx).getInteger() * weight;
//        }else{
//            dfs(nestedList.get(idx).getList(), 0, weight + 1, nestedList.get(idx).getList().size());
//        }
//        dfs(nestedList, idx+1, weight, len);
//    }
//}
