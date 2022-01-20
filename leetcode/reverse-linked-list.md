# linked-list.md

+[reverse-linked-list](#reverse-linked-list)

## reverse-linked-list

https://leetcode.com/problems/reverse-linked-list/

<details><summary>Test Cases</summary><blockquote>
    
```java
public class Tests {
    @Test
    public void testReversePositive() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode res = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))));
        Solution solution = new Solution();
        ListNode head = solution.reverseList(node);
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testReverseRepeat() {
        ListNode node = new ListNode(1, new ListNode(5, new ListNode(1)));
        ListNode res = new ListNode(1, new ListNode(5, new ListNode(1)));
        Solution solution = new Solution();
        ListNode head = solution.reverseList(node);
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testReverseEmpty() {
        ListNode node = new ListNode();
        ListNode res = new ListNode();
        Solution solution = new Solution();
        ListNode head = solution.reverseList(node);
        Assertions.assertEquals(head.val, res.val);
    }
}
```
    
</blockquote></details>    

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode op = null;
        ListNode ip = head;
        ListNode next = null;
        while (ip != null){
            next = ip.next;
            ip.next = op;
            op = ip;
            ip = next;
        }
        return op;
    }
}
```
