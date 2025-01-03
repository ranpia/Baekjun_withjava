package q10828;

import java.util.Scanner;

public class Main {
	int pos = -1;

	int push(int[] stack, int x) {
		pos++;
		stack[pos] = x;
		return pos;
	}

	int pop(int[] stack) {
		if (pos >= 0) {
			int x = stack[pos];
			stack[pos] = 0;
			pos--;
			return x;
		} else {
			return -1;
		}
	}

	int top(int[] stack) {
		if (pos >= 0) {
			int x = stack[pos];
			return x;
		} 
		else {
			return -1;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		int[] stacks = new int[10000];
		String order;
		int x = 0;

		int line = sc.nextInt();
		System.out.println("");
		for (int i = 0; i < line; i++) {
			order = sc.next();
			switch (order) {
			case "push":
				x = sc.nextInt();
				m.pos = m.push(stacks, x);
				break;
			case "pop":
				x = m.pop(stacks);
				System.out.println(x);
				break;
			case "size":
				System.out.println(m.pos + 1);
				break;
			case "empty":
				if (m.pos >= 0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
				break;
			case "top":
				x = m.top(stacks);
				System.out.println(x);
				break;

			}

		}
		sc.close();
	}

}
