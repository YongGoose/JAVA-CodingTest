import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int range = Integer.parseInt(st.nextToken());

        Comparator<Integer> comparator = Comparator
                .comparingInt((Integer num) -> Math.abs(num))
                .thenComparing(num -> num);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);

        for (int i = 0; i < range; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(priorityQueue.remove());
                }
            } else {
                priorityQueue.add(number);
            }
        }
    }
}