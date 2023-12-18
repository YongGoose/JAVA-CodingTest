import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arraySize = Integer.parseInt(st.nextToken());

        mdata[] array = new mdata[arraySize];
        for (int i = 0; i < arraySize; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = new mdata(Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(array);

        int max = 0;
        for (int i = 0; i < arraySize; i++) {
            if (max < (array[i].index - i)) {
                max = array[i].index - i;
            }
        }
        System.out.println(max + 1);
    }

    static class mdata implements Comparable<mdata> {
        int number;
        int index;

        public mdata(int number, int index) {
            super();
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(mdata o) {
            return this.number - o.number;
        }
    }
}