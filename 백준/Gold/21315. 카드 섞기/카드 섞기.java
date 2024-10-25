import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] targetArray;
	static LinkedList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		targetArray = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			targetArray[i] = Integer.parseInt(st.nextToken());
		}

		// 가능한 모든 (k1, k2) 쌍을 시도
		for (int k1 = 1; Math.pow(2, k1) < N; k1++) {
			for (int k2 = 1; Math.pow(2, k2) < N; k2++) {
				// 리스트에 1부터 N까지 숫자 추가
				list = new LinkedList<>();
				for (int x = 1; x <= N; x++) {
					list.add(x);
				}

				shuffle(k1); // 첫 번째 섞기
				shuffle(k2); // 두 번째 섞기

				// 섞인 리스트가 주어진 배열과 같은지 확인
				if (check()) {
					System.out.println(k1 + " " + k2);
					return;
				}
			}
		}
	}

	// 리스트가 주어진 배열과 같은지 확인하는 함수
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			if (targetArray[i] != list.get(i))
				return false;
		}
		return true;
	}

	// 리스트 섞는 함수
	private static void shuffle(int k) {
		int x = 1; // 시작 인덱스

		// k번 반복
		while (k - x + 1 >= 0) {
			int cnt = (int) Math.pow(2, k - x + 1); // 2의 k-x+1 승

			// cnt번 반복
			for (int j = 0; j < cnt; j++) {
				if (x == 1) { // 리스트의 마지막 요소를 첫 번째로 이동
					list.addFirst(list.removeLast());
				} else { // 2의 k-x+2 승 - 1 위치의 요소를 첫 번째로 이동
					list.addFirst(list.remove((int) Math.pow(2, k - x + 2) - 1));
				}
			}

			x++; // 인덱스 증가
		}
	}
}