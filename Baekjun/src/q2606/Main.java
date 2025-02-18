package q2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int bnf(int[][] network, int comNum) {
		int[] visited = new int[comNum+1];
		int corrupted=0; //1번 컴퓨터 제외하고 생각하기
		Queue<Integer> que= new LinkedList<Integer>();
		que.add(1); //초기 값
		visited[1]=1;

		while(que.size()>0) {
			int curpos = que.poll();
			for (int i=1; i<comNum+1; i++) {
				if (network[curpos][i]==1 && visited[i]!=1) {
					que.add(i);
					visited[i]=1;
					corrupted++;
				}
			}
		}
		
		return corrupted;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int comNum = sc.nextInt();
		int[][] network = new int[comNum+1][comNum+1];
		int netNum = sc.nextInt();
		for (int i=0; i<netNum; i++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			// 인접 행렬 업데이트
			network[c1][c2] = 1;
			network[c2][c1] = 1;
		}
		sc.close();
		
		//그래프 탐색
		System.out.print(bnf(network, comNum));
		
		
		
	}

}
