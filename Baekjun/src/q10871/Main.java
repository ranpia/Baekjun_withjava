package q10871;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int x = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int k = sc.nextInt();
			if (k < x)
				arr[i] = k;
		}
		sc.close();

		for (int i = 0; i < N; i++) {
			if (arr[i] > 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}
