import java.util.*;

public class Queue2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextInt()) {
                int n = sc.nextInt();
                
                Stack<Integer> stack = new Stack<>();
                Queue<Integer> queue = new LinkedList<>();
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                
                boolean isStack = true;
                boolean isQueue = true;
                boolean isPQ = true;
                
                for (int i = 0; i < n; i++) {
                    int type = sc.nextInt();
                    int x = sc.nextInt();
                    
                    if (type == 1) {
                        stack.push(x);
                        queue.add(x);
                        pq.add(x);
                    } else {
                        if (isStack) {
                            if (stack.isEmpty() || !stack.pop().equals(x)) isStack = false;
                        }
                        if (isQueue) {
                            if (queue.isEmpty() || !queue.poll().equals(x)) isQueue = false;
                        }
                        if (isPQ) {
                            if (pq.isEmpty() || !pq.poll().equals(x)) isPQ = false;
                        }
                    }
                }
                
                int count = (isStack ? 1 : 0) + (isQueue ? 1 : 0) + (isPQ ? 1 : 0);
                
                if (count == 0) {
                    System.out.println("tidak ada");
                } else if (count > 1) {
                    System.out.println("tidak yakin");
                } else {
                    if (isStack) System.out.println("stack");
                    else if (isQueue) System.out.println("queue");
                    else if (isPQ) System.out.println("priority queue");
                }
            }
        }
    }
}