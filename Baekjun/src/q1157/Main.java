package q1157;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();
		word = word.toUpperCase();

		Map<Character, Integer> search = new HashMap<>();

		for (char c : word.toCharArray()) {
			search.put(c, search.getOrDefault(c, 0) + 1);
		}

		char largerone=' ';
		int maxvalue = 0;


		for (char c : search.keySet()) {
			if (maxvalue < search.get(c)) {
				maxvalue = search.get(c);
				largerone = c;
			} else if (maxvalue == search.get(c) && c!=largerone) {
				largerone = '?';
			}
		}
		
		System.out.println(largerone);
	}

}
