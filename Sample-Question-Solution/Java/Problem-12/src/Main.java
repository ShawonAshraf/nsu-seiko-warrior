import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    static class StackedQueue {
        private Stack<Integer> stackA;
        private Stack<Integer> stackB;

        public StackedQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public int front() {
            return stackA.peek();
        }

        public int back() {
            List<Integer> list = stackA.stream().collect(Collectors.toList());
            return list.get(0);
        }

        public void enQueue(int x) {
            // move everything from A to B
            // so the front elements will go towards back
            // since a stack outputs in reverse (popping)
            while (!stackA.isEmpty()) {
                int el = stackA.pop();
                stackB.push(el);
            }

            // add the new element
            stackA.push(x);

            // now the top of B is actually the previous first element in A
            // which will serve as the front of the queue

            // now move to stack A again
            while (!stackB.isEmpty()) {
                int el = stackB.pop();
                stackA.push(el);

                // so now you have the new element at the bottom, as you'd see
                // in a queue
            }
        }

        public int deQueue() throws Exception {
            if (stackA.isEmpty()) {
                throw new Exception("StackIsEmpty");
            }

            int el = stackA.peek();
            stackA.pop();

            return el;
        }

        public void printQueue() {
            List<Integer> list = stackA.stream().collect(Collectors.toList());
            Collections.reverse(list);

            System.out.println(list);
        }

        public void clear() {
            stackA.clear();
            stackB.clear();
        }
    }


    public static void main(String[] args) {
        StackedQueue stackedQueue = new StackedQueue();

        stackedQueue.enQueue(56);
        stackedQueue.enQueue(100);
        stackedQueue.enQueue(-1);
        stackedQueue.enQueue(65);

        stackedQueue.printQueue();
        System.out.println(stackedQueue.front());
        System.out.println(stackedQueue.back());

        try {
            int el = stackedQueue.deQueue();
            System.out.println("DeQueue => " + el);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stackedQueue.printQueue();
    }
}
