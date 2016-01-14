package leetcode;

/**
 * Created by vishalss on 1/14/2016.
 */

import java.util.Stack;

/*
        Implement the following operations of a queue using stacks.

        push(x) -- Push element x to the back of queue.
        pop() -- Removes the element from in front of queue.
        peek() -- Get the front element.
        empty() -- Return whether the queue is empty.

        Notes:

        You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
        Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
        You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

*/
public class LeetCode232 {

    // Keep two stacks
    Stack<Integer> s1;
    Stack<Integer> s2;
    // to see which one is currently in use.
    int flag;
    public LeetCode232(){
        initialize();
    }

    public void initialize(){
        s1=new Stack<>();
        s2=new Stack<>();
        flag=1;
    }
    // Push element x to the back of queue.
    public void push(int x) {
        // Push will always happen on s1
        // so copy data to s1 if s2 is currently being used
        if(flag==2){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        s1.push(x);
        flag=1;
    }

    // Removes the element from in front of queue.
    public void pop() {
        // pop will always happen on s2.
        // so copy data to s2 if s1 currently in use.
        if(flag==1) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        s2.pop();
        flag=2;
    }

    // Get the front element.
    public int peek() {
        // same as pop without any deletion
        if(flag==1){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        flag=2;
        return s2.peek();

    }

    // Return whether the queue is empty.
    public boolean empty() {
        System.out.println("Flag="+flag);
        if (flag==1)
            return s1.isEmpty();
        else
            return s2.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode232 ob=new LeetCode232();
        ob.push(1);
        System.out.println(ob.peek());
        ob.push(2);
        System.out.println(ob.peek());
        ob.pop();
        System.out.println(ob.peek());
        ob.push(3);
        System.out.println(ob.peek());
        ob.pop();
        System.out.println(ob.peek());
        ob.pop();
        ob.push(4);
        LeetCode232 ob1=new LeetCode232();
        System.out.println(ob1.empty());
    }
}
