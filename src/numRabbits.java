import java.util.HashMap;
import java.util.Map;

public class numRabbits {
    public int numRabbits(int[] answers) {
        int ans = answers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++){
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        for (int key : map.keySet()){
            ans += map.get(key) == 1 ? key : (key - map.get(key) + 1);
        }
        return ans;
    }
}
