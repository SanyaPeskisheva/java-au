# design.md

+ [min-stack](#min-stack)

## min-stack

https://leetcode.com/problems/min-stack/

```java
class MinStack {
    LinkedList head = null;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null) {
            head = new LinkedList(val);
        }
        else{
            LinkedList temp = new LinkedList(val);
            temp.next = head;
            head = temp;
        }    
    }
    
    public void pop() {
        if(head==null) System.out.println("stack is empty");
        else head = head.next;    
    }
    
    public int top() {
        if(head ==null) System.out.println("Stack is empty");
        else return head.val;
        return Integer.MIN_VALUE;    
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        LinkedList temp = head;
        while(temp!=null){
            if(temp.val < min) min = temp.val;
            temp = temp.next;
        }
        return min;    
    }
    
    class LinkedList {
        int val;
        LinkedList next;
        public LinkedList(int val){
            this.val = val;
            this.next = null;
        }
    }
}
```
