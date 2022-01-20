# linked-list.md

+ [intersection-of-two-linked-lists](#intersection-of-two-linked-lists)

## intersection-of-two-linked-lists

https://leetcode.com/problems/intersection-of-two-linked-lists/

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
