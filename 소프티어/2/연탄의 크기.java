import java.io.*;
import java.util.*;

public class Main {

	private static int[] houses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int number = Integer.parseInt(st.nextToken());
		houses = new int[number];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < number; i++) {
			houses[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(houses);
		int end = houses[number - 1];

		int result = 0;
		for(int i = 2; i <= end; i++) {
			int max = 0;
			for(int j = 0; j < number; j++) {
				if(houses[j] % i == 0) {
					max++;
				}
			}
			result = Math.max(result, max);
		}
		System.out.println(result);
	}
}
