import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
  
    public static void main(String[] args) {
        String[] ts1 = {"i","love","leetcode","i","love","coding"};
        System.out.println(Arrays.toString(ts1));
        System.out.println(topKFrequent(ts1, 2));
        
        String[] ts2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(Arrays.toString(ts2));
        System.out.println(topKFrequent(ts2, 4));
    }
  
    public List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
            .sorted()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(k)
            .map(pair -> pair.getKey())
            .collect(Collectors.toList());
    }
}

    
