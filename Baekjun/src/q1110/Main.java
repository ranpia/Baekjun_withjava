package q1110;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		sc.close();
		int n1, n10;
		if (num.length()==1) {
			n10 = 0;
			n1 = Integer.parseInt(num);
		}
		else {
			n10 = Integer.parseInt(num.substring(0,1));
			n1 = Integer.parseInt(num.substring(1));
		}
		int x= (n1+n10)%10 + n1*10;
		int cycle = 1;
		
		while (x!=Integer.parseInt(num)) {
			n1 = x%10;
			n10 = (x-n1)/10;
			x= (n1+n10)%10 + n1*10;
			cycle++;
		}
		System.out.println(cycle);
		

	}

}
