import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int range = Integer.parseInt(st.nextToken());
        mdata[] mdatas = new mdata[range];
        for (int i = 0; i < range; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            mdatas[i] = new mdata(start, end);
        }
        Arrays.sort(mdatas);
        int closeTime = 0;
        int count = 0;
        for (int i = 0; i < range; i++) {
            int startTime = mdatas[i].start;
            int endTime = mdatas[i].end;

            if (startTime >= closeTime) {
                closeTime = endTime;
                count++;
            }
        }
        System.out.println(count);
    }
}

class mdata implements Comparable<mdata> {
    int start;
    int end;

    public mdata(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(mdata o) {
        if (this.end != o.end) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}