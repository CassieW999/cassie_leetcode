import java.util.Deque;
import java.util.LinkedList;

public class simplifyPath {
    public String simplifyPath(String path) {
        //1. use a stack to store strings
        //2. if '..', poll the first
        //3. for loop: '/' + stack.poll()
        Deque<String> s = new LinkedList<>();
        String[] list = path.split("/");
        for (String str : list){
            if (str.equals(".") || str.equals("")){
                continue;
            }else if (str.equals("..")){
                if (!s.isEmpty()){
                    s.pollLast();
                }
            }else{
                s.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = s.size();
        for (int i = 0; i < size; i++){
            sb.append('/');
            sb.append(s.pollFirst());
        }
        return size == 0 ? "/" : sb.toString();
    }
}
