package q1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		sc.close();
		int dir = 0; // 0: 오른쪽 1: 왼쪽아래 2: 아래 3: 오른쪽 위
		int x = 0;
		int y = 0;

		if (num > 1) {
			for (int i = 0; i <= num ; i++) {
				switch (dir) {
				case 0:
					y++;
					break;
				case 1:
					for (; y >=1&&i<=num;) {
						x++;
						y--;
						i++;
					}
					break;
				case 2:
					x++;
					break;
				case 3:
					for (; x >=1&&i<=num;) {
						y++;
						x--;
						i++;
					}
					break;

				}
				dir = (dir + 1) % 4;
			}
		}
		System.out.println((x + 1) + "/" + (y + 1));
	}

}
