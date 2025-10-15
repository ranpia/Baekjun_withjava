package q1003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());

        int[] fibocontents = new int[test];

        for (int i = 0; i< fibocontents.length ; i++){
            Fibonacci fb = new Fibonacci(Integer.parseInt(br.readLine()));
            int[] result = fb.fibonacci();

            for (int j:result){
                bw.write(j+" ");
            }
            if (i!=fibocontents.length-1)
                bw.newLine();
        }



        br.close();
        bw.flush();
        bw.close();
    }
}


class Fibonacci {
    private static int fibo;

    Fibonacci(int fibo){
        this.fibo = fibo;
    }

    public int[] fibonacci (){
        if  (fibo==0) return new int[]{1,0};
        else if (fibo==1) return new int[]{0,1};

        int[][] dp = new int [fibo+1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<=fibo; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        return dp[fibo];
    }
}