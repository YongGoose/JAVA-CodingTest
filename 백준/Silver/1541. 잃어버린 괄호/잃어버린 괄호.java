import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String mission = st.nextToken();
        String[] missionArray = mission.split("-");
        int result = splitPlus(missionArray[0]);
        int missionArrayLength = missionArray.length;
        if (missionArrayLength > 1) {
            for (int i = 1; i < missionArray.length; i++) {
                result -= splitPlus(missionArray[i]);
            }
        }
        System.out.println(result);
    }

    static int splitPlus(String array) {
        String[] nums = array.split("\\+");
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            result += Integer.parseInt(nums[i]);
        }
        return result;
    }
}