import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static String S;
	private static boolean possibleToMakeWord;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		String T = br.readLine();

		generateWord(T);
		System.out.println(possibleToMakeWord ? 1 : 0);
	}

	private static void generateWord(String word) {
		if (possibleToMakeWord) {
			return;
		}

		if (word.length() == S.length()) {
			if (word.equals(S)) {
				possibleToMakeWord = true;
			}
			return;
		}

		if (word.endsWith("A")) {
			generateWord(word.substring(0, word.length() - 1));
		}
		if (word.startsWith("B")) {
			generateWord(new StringBuilder().append(word.substring(1)).reverse().toString());
		}
	}
}
/*
BAABA -> ABAA -> ABA -> AB
 */