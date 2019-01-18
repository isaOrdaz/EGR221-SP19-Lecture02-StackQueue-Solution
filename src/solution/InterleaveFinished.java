package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mhan on 1/18/2017.
 */
public class InterleaveFinished {
    public static void main (String[] args){
        Queue<Integer> q = new LinkedList<>();
        int[] array = {1,2,3,4,100,200,300,400};
        for(int i : array){
            q.add(i);
        }
        interleave(q);
        System.out.println(q); //desired result is [1, 100, 2, 200, 3, 300, 4, 400]
    }


    // post: Values from q moved to s (added in queue order, front to back);
    //       q is empty
    public static void queueToStack(Queue<Integer> q, Stack<Integer> s) {
        while (!q.isEmpty()) {
            int n = q.remove();
            s.push(n);
        }
    }

    // post: Values from s moved to q (added in stack order, top to bottom);
    //       s is empty
    public static void stackToQueue(Stack<Integer> s, Queue<Integer> q) {
        while (!s.isEmpty()) {
            int n = s.pop();
            q.add(n);
        }
    }


    /**
     * One possible solution
     * @param q
     */
    public static void interleave2(Queue<Integer> q) {
        int size = q.size();
        if(q.size()%2 != 0)
            throw new IllegalArgumentException();

        Stack<Integer> s = new Stack<>();
        queueToStack(q, s);
        //q []
        //s [1234ABCD]
        stackToQueue(s, q);
        //q [DCBA4321]
        //s []
        queueToStack(q, s);
        //q []
        //s [DCBA4321]

        for(int i = 0 ; i < size /2 ; i++){
            q.add(s.pop());
        }
        //q [1234]
        //s [DCBA]

        while(!s.isEmpty()){
            q.add(q.remove());
            q.add(s.pop());
        }
        //q [1A2B3C4D]
    }

    /**
     * Another possible solution
     * @param q
     */
    public static void interleave(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        if(q.size()%2 != 0)
            throw new IllegalArgumentException();

        int size = q.size();
        for(int i = 0 ; i < size/ 2; i++){
            s.push(q.remove());
        }
        while(!s.isEmpty())
            q.add(s.pop());

        for(int i = 0 ; i < size; i++){
            if( i < size /2 ) {
                q.add(q.remove());
            } else {
                s.push(q.remove());
            }
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
            q.add(q.remove());
        }
    }
}
