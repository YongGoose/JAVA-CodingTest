import java.io.*;
import java.util.*;

public class 징검다리 {
	static int[] rocks;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		rocks = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			rocks[i] = Integer.parseInt(st.nextToken());
		}
		result = new int[n];
		int len = 1;
		result[0] = rocks[0];

		for(int i = 1; i < n; i++) {
			if(result[len - 1] < rocks[i]) {
				result[len] = rocks[i];
				len++;
				continue;
			}
			int idx = binarySearch(0, len, rocks[i]);
			result[idx] = rocks[i];
		}
		System.out.println(len);
	}
	static int binarySearch(int start, int end, int target) {
		int res = 0;
		while(start < end) {
			int mid = (start + end) / 2;

			if(result[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}
}