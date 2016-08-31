// Implement Stack using Queues
class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        while (q.peek() != x) {
            int a = q.poll();
            q.offer(a);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!q.isEmpty()) {
            q.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (!q.isEmpty()) {
            return q.peek();
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
