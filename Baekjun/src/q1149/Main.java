package q1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int housecount = sc.nextInt();
		int[][] paintcost = new int[housecount][3];
		int[][] lowcost = new int[housecount][3];
		int totallow=Integer.MAX_VALUE;

		for (int i = 0; i < housecount; i++) {
			for (int j = 0; j < paintcost[i].length; j++) {
				paintcost[i][j] = sc.nextInt();
			}
		}
		sc.close();
		

		for (int j = 0; j < paintcost[0].length; j++) {
			lowcost[0][j] =paintcost[0][j];
		}
		
		 for (int i = 1; i < housecount; i++) {
	            lowcost[i][0] = paintcost[i][0] + Math.min(lowcost[i - 1][1], lowcost[i - 1][2]);
	            lowcost[i][1] = paintcost[i][1] + Math.min(lowcost[i - 1][0], lowcost[i - 1][2]);
	            lowcost[i][2] = paintcost[i][2] + Math.min(lowcost[i - 1][0], lowcost[i - 1][1]);
	        }
		
		
		
		
		
		for (int j = 0; j < lowcost[0].length; j++) {
			if (totallow>lowcost[housecount-1][j]) {
				totallow = lowcost[housecount-1][j];
			}
		}
		System.out.println(totallow);

	}

}
