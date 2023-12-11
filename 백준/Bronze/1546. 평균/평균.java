import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int range = sc.nextInt();
        int nums[] = new int[range];
        double newNums[] = new double[range];
        for (int i = 0; i < range; i++) {
            nums[i] = sc.nextInt();
        }
        int maxNum = Arrays.stream(nums).max().orElse(0);
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = Double.valueOf(nums[i]) * 100 / maxNum ;
        }
        System.out.println(Arrays.stream(newNums).average().orElse(0));
    }
}
