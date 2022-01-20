# linked-list.md

+[reverse-linked-list](#reverse-linked-list)

## reverse-linked-list

https://leetcode.com/problems/reverse-linked-list/

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
