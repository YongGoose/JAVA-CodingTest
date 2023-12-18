import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dataNum = Integer.parseInt(st.nextToken());
        mdata[] mdata = new mdata[dataNum];
        String numString = br.readLine();
        String[] strings = numString.split(" ");

        for (int i = 0; i < mdata.length; i++) {
            mdata[i] = new mdata(Integer.parseInt(strings[i]), i);
        }
        Arrays.sort(mdata);
        int sum = 0;
        for (int i = 0; i < mdata.length; i++) {
            sum += mdata[i].number * (mdata.length - i);
        }
        System.out.println(sum);
    }
}

class mdata implements Comparable<mdata> {

    int number;
    int index;

    public mdata(int number, int index) {
        this.number = number;
        this.index = index;
    }
    @Override
    public int compareTo(mdata o) {
        return this.number - o.number;
    }
}