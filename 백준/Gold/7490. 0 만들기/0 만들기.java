import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
	private static int n;
	private static char[] calculates = new char[] {' ', '+', '-'};
	private static ArrayList<ArrayList<Object>> arrayList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			n = Integer.parseInt(br.readLine());

			arrayList = new ArrayList<>();
			ArrayList<Object> characters = new ArrayList<>();
			characters.add('1');
			backTracking(1, 1, characters);

			StringBuilder sb = new StringBuilder();
			for (ArrayList<Object> array : arrayList) {
				for (Object c : array) {
					sb.append(c);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}

	private static void backTracking(int depth, int value, ArrayList<Object> results) {
		if (depth == n) {
			if (value == 0) {
				arrayList.add(results);
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			char operator = calculates[i];
			ArrayList<Object> nResultArray = new ArrayList<>(results);

			int nNumber = calculate(value, depth + 1, calculates[i], results);
			nResultArray.add(operator);
			nResultArray.add(depth + 1);

 			backTracking(depth + 1, nNumber, nResultArray);
		}
	}

	private static int calculate(int value, int currentNumber, char x, ArrayList<Object> results) {
		int length = results.size();
		switch (x) {
			case ' ':
				if (length < 3) {
					value = value * 10 + currentNumber;
				} else if ((char) results.get(length - 2) == (' ')) {
					value = value * 10 + currentNumber;
				} else if ((char)results.get(length - 2) == ('+')) {
					int previousNumber = Integer.parseInt(String.valueOf(results.get(length - 1)));
					value = value - (previousNumber) + (previousNumber * 10 + currentNumber);
				} else {
					int previousNumber = Integer.parseInt(String.valueOf(results.get(length - 1)));
					value = value + (previousNumber) - (previousNumber * 10 + currentNumber);
				}
				break;
			case '+':
				value += currentNumber;
				break;
			case '-':
				value -= currentNumber;
				break;
		}
		return value;
	}
}