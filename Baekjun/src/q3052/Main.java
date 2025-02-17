package q3052;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] remain = new int[10];
		int match = 0;

		for (int i = 0; i < remain.length; i++) {
			remain[i] = sc.nextInt() % 42;
		}

		for (int i = 0; i < remain.length; i++) {
			for (int j = 0; j < remain.length; j++) {
				if (remain[i] == remain[j] && remain[i] != -1&& j!=i) {
					remain[j] = -1;
				}
			}
		}
		
		for (int i=0; i<remain.length; i++) {
			if (remain[i]!=-1) {
				match++;
			}
		}

		System.out.println(match);
	}

}
