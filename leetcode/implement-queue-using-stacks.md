# design.md

+ [implement-queue-using-stacks](#implement-queue-using-stacks)

## implement-queue-using-stacks

https://leetcode.com/problems/implement-queue-using-stacks/

<details><summary>Test Cases</summary><blockquote>
 
```java
public class Tests {
    @Test
    public void test() {
        MyQueue q = new MyQueue();
        Assertions.assertTrue(q.empty());
        q.push(1);
        Assertions.assertEquals(q.peek(), 1);
        q.push(2);
        Assertions.assertEquals(q.peek(), 1);
        q.push(3);
        Assertions.assertEquals(q.peek(), 1);
        Assertions.assertFalse(q.empty());
        q.pop();
        Assertions.assertEquals(q.peek(), 2);
        q.push(4);
        Assertions.assertEquals(q.peek(), 2);
        Assertions.assertFalse(q.empty());
        q.pop();
        Assertions.assertEquals(q.peek(), 3);
        q.pop();
        Assertions.assertEquals(q.peek(), 4);
        q.pop();
        Assertions.assertTrue(q.empty());
    }
}    
```
  
</blockquote></details>    

```java
class MyQueue {
    private Deque<Integer> addS = new LinkedList<>();
    private Deque<Integer> remS = new LinkedList<>();
    public MyQueue() {
           
    }
    
    public void push(int x) {
        addS.push(x);    
    }
    
    public int pop() {
        if(remS.isEmpty()){
            while(!addS.isEmpty()){
                remS.push(addS.pop());
            }
        }
        return remS.pop();    
    }
    
    public int peek() {
        if(remS.isEmpty()){
            while(!addS.isEmpty()){
                remS.push(addS.pop());
            }
        }
        return remS.peek();    
    }
    
    public boolean empty() {
        return addS.isEmpty() && remS.isEmpty();    
    }
}
```
