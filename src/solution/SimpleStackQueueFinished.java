package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimpleStackQueueFinished {
    public static void main(String[] args) {
        //data for Queue a and Stack s
        String[] data = {"four", "score", "and", "seven", "years", "ago"};
        Queue<String> q = new LinkedList<>(); //why LinkedList object gets instantiated?
        Stack<String> s = new Stack<>(); //why just Stack object gets instantiated?

        //Adding each element in data to Queue q and Stack s
        //for Queue, we use "add" for adding an element (adds an element at the end)
        //for Stack, we use "push" for adding an element (pushes an element at the top)
        for (String str : data) {
            q.add(str);
            s.push(str);
        }

        System.out.println("initial queue = " + q);
        System.out.println("initial stack = " + s);

        //Below code removes an element from q until q becomes empty
        while (!q.isEmpty()) {
            String str = q.remove();
            System.out.println("removing " + str + ", now queue = " + q);
        }
        System.out.println();

        //Below code removes an element from s until s becomes empty
        while (!s.isEmpty()) {
            String str = s.pop();
            System.out.println("removing " + str + ", now stack = " + s);
        }
    }
}