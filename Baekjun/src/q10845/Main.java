package q10845;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		for (int i = 0; i < line; i++) {
			String order = sc.next();
			int insert = 0;
			switch (order) {
			case "push":
				insert = sc.nextInt();
				queue.add(insert);
				break;
			case "pop":
				if (queue.size() > 0)
					System.out.println(queue.poll());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if (queue.isEmpty() == true)
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (queue.isEmpty() == true)
					System.out.println(-1);
				else
					System.out.println(queue.peek());
				break;
			case "back":
				if (queue.isEmpty() == true)
					System.out.println(-1);
				else {
					Iterator<Integer> link = queue.iterator();
					for (int j = 0; j < queue.size() - 1; j++) {
						link.remove();
					}
					System.out.println(link.next());
					//System.out.println(queue.toArray()[queue.size() - 1]);
				}
				break;
			}
		}
		sc.close();
	}

}
