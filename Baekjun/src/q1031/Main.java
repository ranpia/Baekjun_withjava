package q1031;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] teamN = new int[N];
		int[] teamM = new int[M];

		// 상대팀 정원을 초과하면 대진 성립 x
		boolean validated = true;
		int teamNtotal = 0;
		int teamMtotal = 0;

		for (int i = 0; i < N; i++) {
			teamN[i] = sc.nextInt();
			if (teamN[i] > M) {
				validated = false;
			}
			teamNtotal += teamN[i];
		}
		for (int i = 0; i < M; i++) {
			teamM[i] = sc.nextInt();
			if (teamM[i] > N) {
				validated = false;
			}
			teamMtotal += teamM[i];
		}

		if (teamMtotal != teamNtotal) {
			validated = false;
		}

		if (validated) {
			Bracket br = new Bracket(teamN, teamM);
			br.createBracket();
		} else {
			System.out.println(-1);
		}
	}

}

class Bracket {
	public int[][] bracket;
	public List<int[]> teamN = new ArrayList<>();
	public List<int[]> teamM = new ArrayList<>();

	Bracket(int[] teamN, int[] teamM) {
		this.bracket = new int[teamN.length][teamM.length];
		// 리스트에 값 추가 값 + 인덱스 번호
		for (int i = 0; i < teamN.length; i++) {
			this.teamN.add(new int[] { teamN[i], i });
		}
		for (int i = 0; i < teamM.length; i++) {
			this.teamM.add(new int[] { teamM[i], i });
		}
		// 크기 순으로 정렬
		this.teamN.sort((a, b) -> Integer.compare(b[0], a[0]));
		// 크기 순 + 후순위로 인덱스가 큰 순서(사전순을 위함)
		this.teamM.sort((a, b) -> {
			int cmp = Integer.compare(b[0], a[0]);
			return (cmp != 0) ? cmp : Integer.compare(b[1], a[1]);
		});

//		System.out.println("teamN");
//		this.teamN.forEach((a) -> System.out.println("값:" + a[0] + "인덱스:" + a[1]));
//
//		System.out.println("teamM");
//		this.teamM.forEach((a) -> System.out.println("값:" + a[0] + "인덱스:" + a[1]));

	}

	public void createBracket() {
		// 대진 횟수가 많은 사람부터 대진 시키기
		// 만약 같다면 마지막 열에 가까운 사람부터 배치하기
		boolean vaildated = true;
		// 배치
		for (int i = 0; i < teamN.size(); i++) {
			int[] x = teamN.get(i);
			for (int j = 0; j < teamM.size(); j++) {
				int[] y = teamM.get(j);
				if (x[0] > 0 && y[0] > 0) {
					bracket[x[1]][y[1]]++;
					x[0]--;
					y[0]--;
				} else {
					teamM.set(j, y);
				}
			}
			teamN.set(i, x);
		}

		// 남은 대전이 있다면 성립안한다.
		for (int i = 0; i < teamN.size(); i++) {
			int[] x = teamN.get(i);
			for (int j = 0; j < teamM.size(); j++) {
				int[] y = teamM.get(j);
				if (x[0] > 0&& y[0] > 0) {
					vaildated = false;
				}
			}
		}

		if (vaildated) {
			for (int i = 0; i < teamN.size(); i++) {
				for (int j = 0; j < teamM.size(); j++) {
					System.out.print(bracket[i][j]);
				}
				System.out.println();
			}
		} else {
			System.out.print(-1);
		}

	}
}