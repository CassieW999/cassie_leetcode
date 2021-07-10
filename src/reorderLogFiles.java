import java.util.Arrays;
import java.util.Comparator;

public class reorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] listA = o1.split(" ", 2);
                String[] listB = o2.split(" ", 2);
                boolean aIsDigit = Character.isDigit(listA[1].charAt(0));
                boolean bIsDigit = Character.isDigit(listB[1].charAt(0));
                if (aIsDigit && bIsDigit) return 0;
                if (aIsDigit || bIsDigit) return aIsDigit ? 1 : -1;
                if (!aIsDigit && !bIsDigit){
                    int cmp = listA[1].compareTo(listB[1]);
                    if (cmp != 0) return cmp;
                    return listA[0].compareTo(listB[0]);
                }
                return 0;
            }
        });
        return logs;
    }
}
