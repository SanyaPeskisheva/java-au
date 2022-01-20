# design.md

+ [implement-stack-using-queues](#implement-stack-using-queues)

## implement-stack-using-queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary><blockquote>

```java
public class Tests {
    @Test
    public void test() {
        MyStack stack = new MyStack();
        Assertions.assertTrue(stack.empty());
        stack.push(10);
        Assertions.assertEquals(stack.top(), 10);
        stack.push(7);
        Assertions.assertEquals(stack.top(), 7);
        stack.pop();
        Assertions.assertEquals(stack.top(), 10);
        stack.push(11);
        Assertions.assertEquals(stack.top(), 11);
        stack.push(21);
        Assertions.assertEquals(stack.top(), 21);
        stack.push(1);
        Assertions.assertEquals(stack.top(), 1);
        stack.pop();
        Assertions.assertEquals(stack.top(), 21);
        stack.pop();
        Assertions.assertEquals(stack.top(), 11);
        stack.pop();
        Assertions.assertEquals(stack.top(), 10);
        stack.pop();
        Assertions.assertTrue(stack.empty());
    }
} 
```

</blockquote></details> 
 
```java
class MyStack {
    Deque<Integer> queue; 
    public MyStack() {
        queue = new LinkedList<>();    
    }
    
    public void push(int x) {
        System.out.println(queue); 
        queue.add(x);    
    }
    
    public int pop() {
        System.out.println(queue); 
        return queue.removeLast();    
    }
    
    public int top() {
        System.out.println(queue); 
        return queue.peekLast();    
    }
    
    public boolean empty() {
        System.out.println(queue); 
        return queue.size() == 0;    
    }
}
```
