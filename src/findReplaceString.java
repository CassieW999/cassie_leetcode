import java.util.Comparator;
import java.util.PriorityQueue;

public class findReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>(){
            @Override
            public int compare(Tuple a, Tuple b){
                return a.indice - b.indice;
            }
        });
        for (int i = 0; i < indices.length; i++){
            int idx = indices[i];
            String src = sources[i];
            String tgt = targets[i];
            if (s.startsWith(src, idx)){
                pq.offer(new Tuple(idx, src, tgt));
            }
        }
        // remove intervals in pq & replace substring
        if (pq.isEmpty()) return s;

        StringBuilder sb = new StringBuilder(s);

        Tuple first = pq.poll();
        while (!pq.isEmpty()){
            Tuple second = pq.poll();
            if (second.indice >= first.end){
                replace(sb, first);
                first = second;
            }
        }
        replace(sb, first);
        return sb.toString();
    }

    public void replace(StringBuilder sb, Tuple t){
        sb.replace(t.indice, t.end, t.target);
    }

    class Tuple {
        int indice;
        int end;
        String source;
        String target;
        public Tuple(int indice, String source, String target){
            this.indice = indice;
            this.source = source;
            this.end = indice + source.length();
            this.target = target;
        }
    }

    public static void main(String[] args) {
    }
}
