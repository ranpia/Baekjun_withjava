package q10828ver2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		myStack mystack = new myStack();
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();

		for (int i = 0; i < line; i++) {
			String order = sc.next();
			int insert = 0;
			switch (order) {
			case "push":
				insert = sc.nextInt();
				mystack.push(insert);
				break;
			case "pop":
				System.out.println(mystack.pop());
				break;
			case "size":
				System.out.println(mystack.size());
				break;
			case "empty":
				System.out.println(mystack.isEmpty());
				break;
			case "top":
				System.out.println(mystack.top());
				break;
			}
			sc.close();
		}

	}

}
