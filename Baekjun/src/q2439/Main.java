package q2439;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=repeat;i++) {
			for (int j=repeat;i<j;j--) {
				System.out.print(" ");
			}
			for (int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
