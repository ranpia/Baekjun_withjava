package q2588;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int n100 = (int)(num2*0.01);
		int n10 = (int)((num2- n100*100)*0.1);
		int n1 = num2 - n100*100 - n10*10;
		
		System.out.println(num1*n1);
		System.out.println(num1*n10);
		System.out.println(num1*n100);
		System.out.println(num1*num2);
		
	}

}
