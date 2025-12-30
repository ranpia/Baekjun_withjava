package q26093;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dp = new int[100][10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] satisfaction = new int[N][K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                satisfaction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxindex = 0;
        int max2index = K-1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                if (i == 0) {
                    dp[i][j] = satisfaction[i][j];
                    continue;
                }
                if (maxindex == j) {
                    dp[i][j] = satisfaction[i][j] + dp[i - 1][max2index];
                } else {
                    dp[i][j] = satisfaction[i][j] + dp[i - 1][maxindex];
                }
            }

            for (int j = 0; j < K; j++) {
                if (dp[i][j] > dp[i][maxindex]) {
                    maxindex = j;
                    if (max2index == maxindex) {
                        max2index = K-j;
                    }
                }
            }
            for (int j = 0; j < K; j++) {
                if (maxindex != j) {
                    if (dp[i][j] > dp[i][max2index]) {
                        max2index = j;
                    }
                }
            }

        }
        int ans = 0;

        for (int i = 0; i < K; i++) {
            ans = Math.max(ans, dp[N - 1][i]);
        }

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}
