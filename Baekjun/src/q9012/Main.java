package q9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		int line = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < line; i++) {
			String VPS = sc.nextLine();
			int left = 0;
			int right = 0;
			boolean ps = true;
			for (int j = 0; j < VPS.length(); j++) {
				if (VPS.charAt(j) == '(') {
					left++;
				} else if (VPS.charAt(j) == ')') {
					right++;
				}

				if (left < right) {
					ps = false;
				}
			}
			if (ps && left == right) {
				System.out.println("YES");
			} else
				System.out.println("NO");

		}
	}

}
