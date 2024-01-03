import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] elements = br.readLine().split(" ");
        long first = Long.parseLong(elements[0]);
        long last = Long.parseLong(elements[1]);

        for (int i = 0; i < mod(first,last); i++) {
            bw.write("1");
        }
        br.close();
        bw.close();
    }

    static long mod(long first, long last) {
        if (last == 0) {
            return first;
        } else {
            return mod(last, first % last);
        }
    }
}