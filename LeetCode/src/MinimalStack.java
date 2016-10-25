import java.util.LinkedList;

/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 11:40 PM.
 */
public class MinimalStack {
    public static void main(String[] args) {
        minStack m = new minStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        System.out.println(m.toString());
        m.pop();
        System.out.println(m.toString());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.toString());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.toString());
        System.out.println(m.getMin());
    }
}

class minStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    /** initialize your data structure here. */
    public minStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.add(0,x);
        if (minStack.size() == 0 || minStack.get(0) >= x)
            minStack.add(0,x);
    }

    public void pop()
    {
        if (minStack.size() >0 && (stack.get(0).equals(minStack.get(0))))
            minStack.remove(0);
        stack.remove(0);
    }

    public int top()
    {
        return stack.get(0);
    }

    public int getMin() {
        return minStack.get(0);
    }
    @Override
    public String toString()
    {
        return stack.toString() + minStack.toString();
    }
}
