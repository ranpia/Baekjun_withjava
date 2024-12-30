package q2741;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num;

		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		for(int i = 0; i<num; i++ ) {
			System.out.println(i+1);
		}
		
		sc.close();
	}

}
