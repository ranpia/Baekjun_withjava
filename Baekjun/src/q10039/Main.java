package q10039;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ave = 0;
		int count = 5;
		
		for (int i = 0; i < count; i++) {
			int score = sc.nextInt();
			if (score < 40) {
				score = 40;
			}
			ave += score;
		}
		System.out.println(ave/count);
		
	}

}
