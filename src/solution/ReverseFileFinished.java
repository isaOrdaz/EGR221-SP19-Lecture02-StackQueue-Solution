package solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/* Prints out all the words in input.txt in reverse order.
 * Then, prints them out again in order but all UPPERCASE. */
public class ReverseFileFinished {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<String> words = new Stack<String>();

        Scanner input = new Scanner(new File("input.txt"));
        while (input.hasNext()) {
            String word = input.next();
            words.push(word);
        }

        Queue<String> q = new LinkedList<String>();
        while (!words.isEmpty()) {
            System.out.println(words.peek());
            q.add(words.pop());
        }

        while (!q.isEmpty()) {
            System.out.println(q.peek().toUpperCase());
            words.push(q.remove());
        }

        while (!words.isEmpty()) {
            q.add(words.pop());
        }

        while (!q.isEmpty()) {
            words.push(q.remove());
        }
    }
}
