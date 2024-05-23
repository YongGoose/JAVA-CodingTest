import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수퍼_바이러스 {
	private static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long k = Long.parseLong(st.nextToken()); // k마리
		long p = Long.parseLong(st.nextToken()); // 증가율
		long n = Long.parseLong(st.nextToken()); // n초

		// k의 p * 10 * n 구해야함.
		long cnt = solve(p, n * 10);

		cnt *= k;
		System.out.println(cnt % MOD);

	}

	public static long solve(long p, long n) {
		if (n == 1) {
			return p;
		}
		long res = solve(p, n / 2);
		if (n % 2 == 0) {
			return (res * res) % MOD;
		}
		res = (res * res) % MOD;
		return (res * p) % MOD;
	}
}