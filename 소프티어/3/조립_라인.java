import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조립_라인 {
	static int[] a, b, aTob, bToa;
	static int[] aResult, bResult;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		a = new int[n];
		b = new int[n];
		aTob = new int[n];
		bToa = new int[n];

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			aTob[i + 1] = Integer.parseInt(st.nextToken());
			bToa[i + 1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		a[n - 1] = Integer.parseInt(st.nextToken());
		b[n - 1] = Integer.parseInt(st.nextToken());

		aResult = new int[n];
		bResult = new int[n];

		aResult[0] = a[0];
		bResult[0] = b[0];

		for (int i = 1; i < n; i++) {
			aResult[i] = Math.min(aResult[i - 1] + a[i], bResult[i - 1] + bToa[i] + a[i]);
			bResult[i] = Math.min(bResult[i - 1] + b[i], aResult[i - 1] + aTob[i] + b[i]);
		}
		System.out.println(Math.min(aResult[n - 1], bResult[n - 1]));
	}
}