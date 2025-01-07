package q2292;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roomNum = sc.nextInt();
		sc.close();
		int result = 1;
		int i=1;
		if (roomNum > 1) {
			for (i=0;result<roomNum;i++) {
				result += 2*i + 2*(i+1)+2*(i+2);
			}
			System.out.println(i+1);
		}
		else
			System.out.println(i);

	}

}
