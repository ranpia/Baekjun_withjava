package q1031;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		
		for (int i=0; i<N; i++) {
			teamN[i]=sc.nextInt();
			if (teamN[i]>M) {
				validated = false;
			}
		}
		for (int i=0; i<M; i++) {
			teamM[i]=sc.nextInt();
			if (teamM[i]>N) {
				validated = false;
			}
		}
		
		if (validated) {
			Bracket br = new Bracket(teamN, teamM);
			br.createBracket();
		}
		else {
			System.out.println(-1);
		}
	}

}


class Bracket{
	public int[][] bracket;
	public int[] teamN;
	public int[] teamM;
	
	Bracket(int[] teamN, int[] teamM) {
		this.bracket = new int[teamN.length][teamM.length];
		this.teamN = teamN;
		this.teamM = teamM;
	}
	
	public void createBracket() {
		// 대진 횟수가 많은 사람부터 대진 시키기
		// 만약 같다면 마지막 행 마지막 열에 가까운 사람부터?
		// 중복 확인용 map
		Map<Integer, Integer> teamNDuple = new HashMap<>();
		
		for(int i=0; i<teamN.length; i++) {
			teamNDuple.put(teamN[i], teamNDuple.getOrDefault(teamN[i], 0)+1);
		}
		
		Arrays.sort(teamN);
	}
}