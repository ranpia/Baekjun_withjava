package q2445;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();

		for (int i = 1; i <= n; i++) {
			String line = String.format("%s%s%s", "*".repeat(i), " ".repeat(2 * (n - i)), "*".repeat(i));
			System.out.println(line);
		}

		for (int i = n - 1; i >= 1; i--) {
			String line = String.format("%s%s%s", "*".repeat(i), " ".repeat(2 * (n - i)), "*".repeat(i));
			System.out.println(line);
		}
	}

}
