# linked-list.md

+ [sort-list](#sort-list)

## sort-list

https://leetcode.com/problems/sort-list/
 
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
