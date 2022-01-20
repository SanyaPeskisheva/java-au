# linked-list.md

+ [merge-two-sorted-lists](#merge-two-sorted-lists)

## merge-two-sorted-lists

https://leetcode.com/problems/merge-two-sorted-lists/

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode ans = new ListNode(-1);
        ListNode res = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.next = l1;
                ans = ans.next;
                l1 = l1.next;
            } else if (l2.val <= l1.val) {
                ans.next = l2;
                ans = ans.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            ans.next = l1;
            ans = ans.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ans.next = l2;
            ans = ans.next;
            l2 = l2.next;
        }
        return res.next;
    }
}
```
