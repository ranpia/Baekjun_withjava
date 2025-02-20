package q2193;

import java.util.Scanner;

public class Main {

	// 이친수는 0으로 시작하지 않는다. 100 은 일의 자리만 2개 1000 은 십의 자리 일의자리 중복없이 총 3개 10000은 백의 자리가 1일때 2 0일때는 3
	// 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Pinary pin = new Pinary(N);
		System.out.println(pin.caculatePinary());
		
	}

}

class Pinary {
	public int N;
	public long[] pinarycase;

	Pinary(int N) {
		this.N = N;
		this.pinarycase = new long[N+1];
	}

	public long caculatePinary() {
		for (int i = 0; i < this.N+1; i++) {
			if (i<3) {
				pinarycase[i]=1;
			}
			else {
				pinarycase[i]=pinarycase[i-1]+pinarycase[i-2];
			}
		}

		return pinarycase[N];
	}
	
}