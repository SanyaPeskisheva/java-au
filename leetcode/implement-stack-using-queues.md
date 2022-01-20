# design.md

+ [implement-stack-using-queues](#implement-stack-using-queues)

## implement-stack-using-queues

https://leetcode.com/problems/implement-stack-using-queues/
 
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
