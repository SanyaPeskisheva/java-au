# linked-list.md

+ [sort-list](#sort-list)

## sort-list

https://leetcode.com/problems/sort-list/

<details><summary>Test Cases</summary><blockquote>
 
```java
public class Tests {
    @Test
    public void testSortPositive() {
        ListNode node = new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1))));
        ListNode res = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Solution solution = new Solution();
        ListNode head = solution.sortList(node);
        for (int i = 0; i < 4; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testSortNegative() {
        ListNode node = new ListNode(-2, new ListNode(4, new ListNode(0, new ListNode(1,  new ListNode(-9)))));
        ListNode res = new ListNode(-9, new ListNode(-2, new ListNode(0, new ListNode(1,  new ListNode(4)))));
        Solution solution = new Solution();
        ListNode head = solution.sortList(node);
        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }

    @Test
    public void testSortEmpty() {
        ListNode node = null;
        ListNode res = null;
        Solution solution = new Solution();
        ListNode head = solution.sortList(node);
        Assertions.assertEquals(head, res);
    }

    @Test
    public void testSortRepeat() {
        ListNode node = new ListNode(2, new ListNode(2, new ListNode(2)));
        ListNode res = new ListNode(2, new ListNode(2, new ListNode(2)));
        Solution solution = new Solution();
        ListNode head = solution.sortList(node);
        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(head.val, res.val);
            head = head.next;
            res = res.next;
        }
    }
}
```
 
</blockquote></details>
 
```java
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head ; 
        ListNode mid = getMid(head) ; 
        ListNode left = sortList(head) ;
        ListNode right = sortList(mid);
        return merge(left , right);  
    }
    
    ListNode merge(ListNode left , ListNode right){
        ListNode merged =new ListNode() ; 
        ListNode head2= merged ; 
        while(left!= null && right != null){
            if(left.val <= right.val){  
                head2.next = left ; 
                left = left.next ; 
                head2=head2.next ; 
            }
            else {
                head2.next = right; 
                right = right.next ; 
                head2=head2.next ;
            }
        }
        head2.next = left != null ? left : right ; 
        return merged.next ; 
    }
    
    ListNode getMid(ListNode head){
        ListNode slow = null ; 
        ListNode fast = head ; 
        while(fast != null && fast.next !=null){
            slow = (slow == null )? fast : slow.next ; 
            fast = fast.next.next ; 
        }
        ListNode mid = slow.next ; 
        slow.next = null ;   
        return mid ;
    }
}
```
