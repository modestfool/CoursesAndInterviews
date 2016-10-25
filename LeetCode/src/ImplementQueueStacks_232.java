import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 6:25 AM.
 */
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
public class ImplementQueueStacks_232
{
    class MyQueue {
        // Push element x to the back of queue.
        private Stack<Integer> myQueue;
        private Stack<Integer> outQueue;
        MyQueue()
        {
            myQueue = new Stack<>();
            outQueue = new Stack<>();
        }
        public void push(int x) {
            myQueue.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            peek();
            outQueue.pop();
        }

        // Get the front element.
        public int peek() {
            if (outQueue.empty())
                while (!myQueue.empty())
                    outQueue.push(myQueue.pop());
            return outQueue.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return myQueue.isEmpty() && outQueue.isEmpty();
        }
    }
}
