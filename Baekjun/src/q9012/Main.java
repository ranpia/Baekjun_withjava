package q9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < line; i++) {
			Stack<String> stack = new Stack<String>();
			String VPS = sc.nextLine();
			boolean truth = true;
			for (int j = 0; j < VPS.length(); j++) {
				if (VPS.charAt(j) == '(')
					stack.add(VPS.substring(j, j + 1));
				else {
					if (stack.size() > 0)
						stack.pop();
					else
						truth = false;
				}
			}
			if (stack.size() == 0 && truth)
				System.out.println("YES");
			else
				System.out.println("NO");
			
			sc.close();

		}
	}

}
