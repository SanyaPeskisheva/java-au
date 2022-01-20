# linked-list.md

+ [palindrome-linked-list](#palindrome-linked-list)

## palindrome-linked-list

https://leetcode.com/problems/palindrome-linked-list/

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        ListNode retwo = null;
        ListNode temp;
        while (two != null && two.next != null){
            two = two.next.next;
            temp = one.next;
            one.next = retwo;
            retwo = one;
            one = temp;
        }
        if (two != null){
            one = one.next;
        }
        while (retwo != null && one != null) {
            if (retwo.val != one.val)
                return false;
            retwo = retwo.next;
            one = one.next;
        }
        return true;
    }
}
```
