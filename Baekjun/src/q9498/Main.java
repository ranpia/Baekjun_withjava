package q9498;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		switch ((int)n/10) {
			case 10:
				System.out.println("A");
				break;
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
				break;
			default:
				System.out.println("F");
				break;
		}
		
		/*if (n<=100 && n >= 90) {
			System.out.println("A");
		} 
		else if (n >= 80) {
			System.out.println("B");
		}
		else if (n >= 70) {
			System.out.println("C");
		}
		else if (n >= 60) {
			System.out.println("D");
		}
		else if (n>=0 && n<60){
			System.out.println("F");
		}
		else {
			System.out.println("Out of range!");
		}*/
		
		

	}
}
