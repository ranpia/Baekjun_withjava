package q3040;

import java.util.Scanner;

public class Main {
	//이거 말고 백트래킹으로도 풀어보기
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int total=0;
		int[] arr=new int [9];
		
		for (int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
			total+=arr[i];
		}
		sc.close();
		total-=100;
		
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				if (arr[i]==0)
					break;
				if (arr[j]==0)
					break;
				if ((arr[i]+arr[j])==total&&i!=j) {
					arr[i]=0;
					arr[j]=0;
				}
			}
		}
		
		for (int i=0;i<9;i++) {
			if (arr[i]!=0) {
				System.out.println(arr[i]);
			}
		}

	}

}
