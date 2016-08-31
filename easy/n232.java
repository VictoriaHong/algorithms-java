// Implement Queue using Stacks
class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int a = s1.pop();
                s2.push(a);
            }
        }
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int a = s1.pop();
                s2.push(a);
            }
        }
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
