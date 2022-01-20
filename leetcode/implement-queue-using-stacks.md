# design.md

+ [implement-queue-using-stacks](#implement-queue-using-stacks)

## implement-queue-using-stacks

https://leetcode.com/problems/implement-queue-using-stacks/

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
