import java.util.*;

public class so{
    public static List<String> topK(int k, Iterator<String> iter) {
        PriorityQueue<String> minHeap
                = new PriorityQueue<String>(k, new Comparator<String>(){
                    public int compare(String s1, String s2){
            return Integer.compare(s1.length(), s2.length());
        }
        });
        while (iter.hasNext()) {
            minHeap.add(iter.next());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }
}