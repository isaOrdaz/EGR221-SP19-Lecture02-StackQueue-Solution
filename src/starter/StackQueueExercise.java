package starter;// Program that demonstrates some stack/queue operations

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueExercise {
    public static void main(String[] args) {
        Queue<Integer> q = makeQueueOfMultiples(6, 3);
        System.out.println("initial queue = " + q);
        System.out.println("sum = " + sum(q));
        System.out.println("after sum queue = " + q);
        System.out.println();

        Stack<Integer> s = new Stack<Integer>();
        System.out.println("current queue = " + q);
        queueToStack(q, s);
        System.out.println("after queueToStack:");
        System.out.println("    queue = " + q);
        System.out.println("    stack = " + s);
        System.out.println();

        s = makeStackOfMultiples(6, 5);
        System.out.println("initial stack = " + s);
        System.out.println("sum = " + sum(s));
        System.out.println("after sum stack = " + s);
        System.out.println();

        System.out.println("current queue = " + q);
        System.out.println("current stack = " + s);
        stackToQueue(s, q);
        System.out.println("after stackToQueue:");
        System.out.println("    stack = " + s);
        System.out.println("    queue = " + q);
    }

    // pre : count >= 0
    // post: returns a queue of count multiples of n
    public static Queue<Integer> makeQueueOfMultiples(int count, int n) {
        Queue<Integer>  q = new LinkedList<>();

        for(int i = 1 ; i <= count ; i++){
            q.add(i * n);
        }
//        int i = 1;
//        while(q.size() < count){
//            q.add(n * i);
//            i++;
//        }
        return q;
    }

    // pre : count >= 0
    // post: returns a stack of count multiples of n
    public static Stack<Integer> makeStackOfMultiples(int count, int n) {
        Stack<Integer> s = new Stack<>();
        for(int i = 1 ; i <= count ; i++){
            s.push(i * n);
        }
        return s;
    }

    // post: Values from q moved to s (added in queue order, front to back);
    //       q is empty
    public static void queueToStack(Queue<Integer> q, Stack<Integer> s) {
        //Implement me
    }

    // post: Values from s moved to q (added in stack order, top to bottom);
    //       s is empty
    public static void stackToQueue(Stack<Integer> s, Queue<Integer> q) {
        //Implement me
    }

    // post: returns the sum of the values in q
    // This method should NOT change the content of q after the call
    public static int sum(Queue<Integer> q) {
        int sum = 0;
        //implement me
        return sum;
    }

    // post: returns the sum of the values in s
    // This method should NOT change the content of s after the call
    // You may use queue as your additional storage
    public static int sum(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;

        //implement me
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            sum += n;
        }

        //s is empty!!!
        //q is full (12, 9, 6, 3)
        //move all elements in q to s
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        //s = 3, 6, 9, 12

        //s -> q
        while(!s.empty()){
            q.add(s.pop());
        }
        //s is empty
        //q is full (3,6, 9,12)
        //q -> s
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        return sum;

    }
    public static int sum2(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        //add for loop for alternative solution
        //implement me
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
            sum += n;
        }

        //s is empty!!!
        //q is full (12, 9, 6, 3)
        //move all elements in q to s
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        //s = 3, 6, 9, 12

//        //s -> q
//        while(!s.empty()){
//            q.add(s.pop());
//        }
//        //s is empty
//        //q is full (3,6, 9,12)
//        //q -> s
//        while(!q.isEmpty()){
//            s.push(q.remove());
//        }
        return sum;

    }
}
