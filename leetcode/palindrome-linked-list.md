# linked-list.md

+ [palindrome-linked-list](#palindrome-linked-list)

## palindrome-linked-list

https://leetcode.com/problems/palindrome-linked-list/

<details><summary>Test Cases</summary><blockquote>

```java
public class Tests {
    @Test
    public void testPalindromeOddLengthTrue() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(node));
    }

    @Test
    public void testPalindromeOddLengthFalse() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isPalindrome(node));
    }


    @Test
    public void testPalindromeEvenLengthTrue() {
        ListNode node = new ListNode(5, new ListNode(6, new ListNode(6, new ListNode(5))));
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(node));
    }

    @Test
    public void testPalindromeEvenLengthFalse() {
        ListNode node = new ListNode(5, new ListNode(6, new ListNode(5, new ListNode(7))));
        Solution solution = new Solution();
        Assertions.assertFalse(solution.isPalindrome(node));
    }

    @Test
    public void testPalindromeEmpty() {
        ListNode node = new ListNode();
        Solution solution = new Solution();
        Assertions.assertTrue(solution.isPalindrome(node));
    }
}
```

</blockquote></details>

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
