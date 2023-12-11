
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        String number = scanner.next();
        char[] nums = number.toCharArray();

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] - '0';
        }
        System.out.println(result);
    }
}
