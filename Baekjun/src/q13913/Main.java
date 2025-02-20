package q13913;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		que.add(N);

		int search = N;
		Route rou = new Route(K);
		// 경로 저장 방식
		// 트리 형태로 저장하기 or 리스트에서 경로 탐색?
		// 1/ 1 1 1 / 3 3 3
		// hashmap 으로 경로 저장?
		
		while (true) {
			search = que.poll();
			if (search == K) {
				break;
			} 
			else if((search < K && search > 0)||(search > K && search < 0)) {
				que.add(search * 2);
			}
			else {
				que.add(search - 1);
				que.add(search + 1);
				
			}
		}
	}

}

class Route{
	public ArrayList<Integer> route;
	public int cur_pos;
	
	public Route(int pos) {
		this.cur_pos=pos;
		route = new ArrayList<>();
		route.add(cur_pos);
	}
	
	public void addRoute(int newpos) {
		route.add(newpos);
	}
}
