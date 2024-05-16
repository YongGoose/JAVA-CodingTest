import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 카메라 개수
			int m = Integer.parseInt(st.nextToken()); // 카메라를 설치할 수 있는 곳

			int[] cameras = new int[m];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				double temp = Double.parseDouble(st.nextToken());
				cameras[i] = (int) (temp * 1000); // 정밀도를 맞추기 위해 1000 곱하기
			}

			int start = 0;
			int end = 500_000;
			int result = 0; // int로 변경하여 중간 값을 저장
			while (start <= end) {
				int mid = (start + end) / 2;

				int cnt = comparePoints(mid, cameras);
				if (cnt >= n) {
					result = mid;
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			System.out.printf("%.2f%n", result / 1000.0); // 1000.0으로 나누어 소수점 둘째 자리까지 출력
		}
	}

	static int comparePoints(int mid, int[] cameras) {
		int cnt = 1;
		int sum = 0;

		for (int i = 1; i < cameras.length; i++) {
			sum += cameras[i] - cameras[i - 1];

			if (sum >= mid) {
				sum = 0;
				cnt++;
			}
		}
		return cnt;
	}
}
