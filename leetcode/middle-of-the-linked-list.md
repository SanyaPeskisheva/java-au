# linked-list.md

+ [middle-of-the-linked-list](#middle-of-the-linked-list)

## middle-of-the-linked-list

https://leetcode.com/problems/middle-of-the-linked-list/

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        return first;
    }
}
```
