import java.util.HashMap;
import java.util.Map;

public class shortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        StringBuilder s = new StringBuilder();
        licensePlate=licensePlate.toLowerCase();
        for(int i=0;i<licensePlate.length();i++){
            if(95<licensePlate.charAt(i) && licensePlate.charAt(i)<123)
                s.append(licensePlate.charAt(i));
        }

        Map<Character,Integer> mas = new HashMap<>();
        for(char x: s.toString().toCharArray())
            mas.put(x,mas.getOrDefault(x,0)+1);

        int index=0, len=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            boolean present=true;

            Map<Character,Integer> map = new HashMap<>();
            for(char x: words[i].toCharArray())
                map.put(x,map.getOrDefault(x,0)+1);

            for(int j=0;j<s.length();j++){
                if(!map.containsKey(s.charAt(j)) || map.get(s.charAt(j))<mas.get(s.charAt(j))){
                    present=false;
                    break;
                }
            }
            if(present && len>words[i].length()){
                len=words[i].length();
                index=i;
            }
        }
        return words[index];
    }
}
