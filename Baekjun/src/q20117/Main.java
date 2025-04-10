package q20117;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] hobancow = new int[N];
		int middleindex;
		int total = 0;

		for (int i = 0; i < N; i++) {
			hobancow[i] = sc.nextInt();
			total += hobancow[i];
		}
		Arrays.sort(hobancow);
		int avg = total / N;

		Greedyseller g = new Greedyseller(avg, hobancow);
		System.out.println(g.sell());

	}

}

class Greedyseller {
	private int avg;
	private int[] group;
	private int middleindex;
	private int totalsell = 0;

	public Greedyseller(int avg, int[] group) {
		this.avg = avg;
		this.group = group;
		if (group.length % 2 == 1) {
			middleindex = (group.length + 1) / 2 -1;
		} else {
			middleindex = group.length / 2 ;
		}
	}

	public int sell() {
		if (group.length % 2 == 1) {
			totalsell+=group[middleindex];
			for (int i = middleindex+1; i < group.length; i++) {
				totalsell += 2 * group[i];
			}
		} else {
			for (int i = middleindex; i < group.length; i++) {
				totalsell += 2 * group[i];
			}
		}
		return totalsell;
	}

}