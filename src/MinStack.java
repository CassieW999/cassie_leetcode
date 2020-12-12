import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    Stack<MStack> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        stack.push(new MStack(x, Math.min(x, stack.isEmpty()?x:stack.peek().min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {

        return stack.peek().value;
    }

    public int getMin() {

        return stack.peek().min;
    }

    static class MStack {

        int value;
        int min;

        public MStack(int value, int min) {
            this.value = value;
            this.min = min;
        }

    }
}
