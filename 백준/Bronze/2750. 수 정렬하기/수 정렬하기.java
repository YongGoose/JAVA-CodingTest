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
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());

        nums = new int[range];

        for (int i = 0; i < range; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i] = Integer.parseInt(st.nextToken());
        }

        /*
        for 반복문을 두개 사용함으로써 이중 반복문을 구현하고, 
        j < range - 1 - i; 이렇게 j의 범위를 구현했다. 
        이렇게 하면 두번째 for 반복문이 반복될 때마다 맨 뒤에 있는 인덱스 하나씩 범위가 줄게 된다.
         */
        for (int i = 0; i < range - 1; i++) {
            for (int j = 0; j < range - 1 - i; j++) {
                swap(j);
            }
        }
        for (int i = 0; i < range; i++) {
            System.out.println(nums[i]);
        }
    }

    static void swap(int i) {
        if (nums[i + 1] < nums[i]) {
            int swap;
            swap = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = swap;
        }
    }
}