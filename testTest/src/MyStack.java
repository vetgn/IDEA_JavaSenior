import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZJJ
 * #Description MyStack
 * #Date: 2023/2/13 11:11
 */
public class MyStack {
    Deque<Integer> deque;

    public MyStack() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        deque.add(x);
    }

    public int pop() {
        return deque.removeLast();
    }

    public int top() {

            return deque.peekLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
