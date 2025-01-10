package q10828ver3;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();

		for (int i = 0; i < line; i++) {
			String order = sc.next();
			int insert = 0;
			switch (order) {
			case "push":
				insert = sc.nextInt();
				stack.push(insert);
				break;
			case "pop":
				if(stack.size()>0)
					System.out.println(stack.pop());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty()==true)
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (stack.isEmpty()==true)
					System.out.println(-1);
				else
					System.out.println(stack.lastElement());
				break;
			}
		}
		sc.close();
	}

}
