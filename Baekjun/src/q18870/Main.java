package q18870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{

		int num = Integer.parseInt(br.readLine());;
		String[] dotsString = br.readLine().split(" ");
		int x[] = new int[num];
		ArrayList<Integer> comparex= new ArrayList<Integer>();
		int xi[] = new int[num];

		for (int i = 0; i < num; i++) {
			x[i] = Integer.parseInt(dotsString[i]);
			if (!comparex.contains(x[i])) {
				comparex.add(x[i]);
			}
		}
		
		for (int i=0; i<num;i++) {
			for (int j=0; j<comparex.size();j++) {
				if (x[i]>comparex.get(j)) {
					xi[i]++;
				}
			}
		}

		for (int i = 0; i < num; i++) {
			bw.write(xi[i] + " ");
            bw.flush();
		}
		bw.close();

	}

}
