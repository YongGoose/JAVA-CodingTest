import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> boxes = new ArrayList<>();
    static ArrayList<Integer> crains = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            crains.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        boxes.sort(Collections.reverseOrder());
        crains.sort(Collections.reverseOrder());
        if (boxes.get(0) > crains.get(0)) {
            System.out.println("-1");
            return;
        }
        int cnt = 0;
        while (!boxes.isEmpty()) {
            int boxId = 0;
            for (int i = 0; i < crains.size();) {
                if (crains.get(i) >= boxes.get(boxId)) {
                    i++;
                    boxes.remove(boxId);
                } else if (crains.get(i) < boxes.get(boxId)) {
                    boxId++;
                }
                if (boxId == boxes.size()) {
                    break;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}

