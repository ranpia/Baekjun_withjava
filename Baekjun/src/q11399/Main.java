package q11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int Pi[] =new int[N]; 
		
		for (int i=0; i<N; i++) {
			Pi[i]=sc.nextInt();
		}
		
		Arrays.sort(Pi);
		
		int total=0;
		int sum = 0;
		
			for(int minute : Pi) {
				sum+=minute;
				total+=sum;
			}
		
		
		System.out.print(total);
	}

}
