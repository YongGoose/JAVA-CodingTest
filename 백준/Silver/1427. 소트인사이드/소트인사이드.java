import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String number = st.nextToken();
        String[] array = number.split("");
        mdata[] mdataArray = new mdata[array.length];

        for (int i = 0; i < array.length; i++) {
            mdataArray[i] = new mdata(Integer.parseInt(array[i]), i);
        }
        Arrays.sort(mdataArray);
        for (int i = 0; i < mdataArray.length; i++) {
            System.out.print(mdataArray[i].number);
        }
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
        return o.number - this.number;
    }
}