# linked-list.md

+ [middle-of-the-linked-list](#middle-of-the-linked-list)

## middle-of-the-linked-list

https://leetcode.com/problems/middle-of-the-linked-list/

<details><summary>Test Cases</summary><blockquote>
    
```java
public class Tests {
    @Test
    public void testMiddleOddLength() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = new ListNode(3, new ListNode(4, new ListNode(5)));
        Solution solution = new Solution();
        ListNode head = solution.middleNode(node);
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testMiddleEvenLength() {
        ListNode node = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(1))));
        ListNode res = new ListNode(7, new ListNode(1));
        Solution solution = new Solution();
        ListNode head = solution.middleNode(node);
        for (int i = 0; i < 2; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testMiddleEmpty() {
        ListNode node = new ListNode();
        ListNode res = new ListNode();
        Solution solution = new Solution();
        ListNode head = solution.middleNode(node);
        Assertions.assertEquals(head.val, res.val);
    }
}        
```
    
</blockquote></details>

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
