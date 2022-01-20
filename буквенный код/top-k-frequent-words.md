# stream.md

+ [top-k-frequent-words](#top-k-frequent-words)

## top-k-frequent-words

https://leetcode.com/problems/top-k-frequent-words 

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
    private Solution sol;
    @BeforeEach
    void setUp() {
        sol = new Solution();
    }
    @org.junit.jupiter.api.Test
    void testTopKFrequent() {
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> expected = List.of("the", "is", "sunny", "day");
        assertEquals(expected, sol.topKFrequent(words, 4));
    }
}
```

</blockquote></details>

```java
class Solution {
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
```
