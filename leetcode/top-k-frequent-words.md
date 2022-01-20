# stream.md

+ [top-k-frequent-words](#top-k-frequent-words)

## top-k-frequent-words

https://leetcode.com/problems/top-k-frequent-words 

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
