# linked-list.md

+ [intersection-of-two-linked-lists](#intersection-of-two-linked-lists)

## intersection-of-two-linked-lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

<details><summary>Test Cases</summary><blockquote>

```java
public class Tests {
    @Test
    public void testNullIntersection() {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node2 = new ListNode(9, new ListNode(11, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        ListNode head = solution.getIntersectionNode(node1, node2);
        Assertions.assertEquals(head, null);
    }

    @Test
    public void testIntersection() {
        ListNode node1 = new ListNode(1, new ListNode(2));
        ListNode node2 = new ListNode(9, node1);
        Solution solution = new Solution();
        ListNode head = solution.getIntersectionNode(node1, node2);
        Assertions.assertEquals(head.val, 1);
    }

    @Test
    public void testEmptyListIntersection() {
        ListNode node1 = new ListNode(1, new ListNode(2));
        ListNode node2 = null;
        Solution solution = new Solution();
        ListNode head = solution.getIntersectionNode(node1, node2);
        Assertions.assertEquals(head, null);
    }
}
```

</blockquote></details>    

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a= headA, b=headB;        
        int l1=0,l2=0;        
        while (a!=null || b!=null){
            if (a!=null){
                l1++;
                a=a.next;
            }
            if (b!=null){
                l2++;
                b=b.next;
            }
        }        
        a=headA;
        b=headB;        
        for (int i=0; i<Math.abs(l1-l2); i++){
            if (l1>l2) a=a.next;
            if (l1<l2) b=b.next;
        }        
        while (a!=null && b!=null){

            if (a==b) return a;
            a=a.next;
            b=b.next;
        }        
        return null;
    }
}
```
