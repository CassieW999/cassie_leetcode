import java.util.ArrayDeque;
import java.util.Deque;

public class BoundedBlockingQueue {
    Deque<Integer> queue;
    Deque<Integer> waitqueue;
    int capacity;
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<Integer>();
        waitqueue = new ArrayDeque<Integer>();
    }

    public void enqueue(int element) throws InterruptedException {
        // 1. if empty & waitqueue[0] = -1, enqueue + dequeue -> dont enqueue + pop waitqueue[0]
        // 2. if queue.full, waitqueue.add(element)
        // 3. else queue.add(element)
        if (queue.size() == capacity){
            waitqueue.addFirst(element);
            return;
        }
        queue.addFirst(element);
        if (waitqueue.size() > 0 && waitqueue.getFirst() == -1){
            waitqueue.removeFirst();
            dequeue();
        }
    }

    public int dequeue() throws InterruptedException {
        // 1. if empty, waitqueue.add(-1)
        // 2. else queue.dequeue
        // 3. if waitqueue[1] != -1, queue.add(waitqueue[1])
        if (queue.size() == 0){
            waitqueue.addFirst(-1);
            return -1;
        }
        int res = queue.removeLast();
        if (waitqueue.size() > 0 && waitqueue.getFirst() != -1){
            queue.addFirst(waitqueue.removeFirst());
        }
        return res;
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) throws InterruptedException {
        int capacity = 2;
        BoundedBlockingQueue q = new BoundedBlockingQueue(capacity);
        q.enqueue(1);
        q.dequeue();
        q.dequeue();
        q.enqueue(0);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
    }
}
