# linked-list.md

+ [merge-two-sorted-lists](#merge-two-sorted-lists)

## merge-two-sorted-lists

https://leetcode.com/problems/merge-two-sorted-lists/

<details><summary>Test Cases</summary><blockquote>
    
```java
public class Tests {
    @Test
    public void testMerge() {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node2 = new ListNode(4, new ListNode(5));
        Solution solution = new Solution();
        ListNode head = solution.mergeTwoLists(node1, node2);
        ListNode res = new ListNode(1, new ListNode(2,  new ListNode(3,  new ListNode(4, new ListNode(5)))));
        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testMerge2() {
        ListNode node1 = new ListNode(1, new ListNode(5, new ListNode(10)));
        ListNode node2 = new ListNode(2, new ListNode(7, new ListNode(9)));
        Solution solution = new Solution();
        ListNode head = solution.mergeTwoLists(node1, node2);
        ListNode res = new ListNode(1, new ListNode(2,  new ListNode(5,  new ListNode(7, new ListNode(9, new ListNode(10))))));
        for (int i = 0; i < 6; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testMergeOneEmpty() {
        ListNode node1 = new ListNode(3, new ListNode(4, new ListNode(5)));
        ListNode node2 = null;
        Solution solution = new Solution();
        ListNode head = solution.mergeTwoLists(node1, node2);
        ListNode res = new ListNode(3, new ListNode(4, new ListNode(5)));
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testMergeBothEmpty() {
        ListNode node1 = null;
        ListNode node2 = null;
        Solution solution = new Solution();
        ListNode head = solution.mergeTwoLists(node1, node2);
        ListNode res = null;
        Assertions.assertEquals(head, res);
    }
}
```
  
</blockquote></details>

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
