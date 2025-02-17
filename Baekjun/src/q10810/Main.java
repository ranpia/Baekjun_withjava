package q10810;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] busket = new int[N];
		
		for (int i=0 ; i<M; i++) {
			int start= sc.nextInt();
			int end = sc.nextInt();
			int ballnum = sc.nextInt();
			
			for (int j=start-1;j<end;j++) {
				busket[j]=ballnum;
			}
		}
		
		sc.close();
		for (int i: busket) {
			System.out.print(i+" ");
		}

	}

}
