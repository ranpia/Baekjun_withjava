package q2618;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    static int dist(int a, int b, int[][] cases, int n, int car) {
        // a: 해당 차가 마지막으로 처리한 사건 번호
        // b: 다음 사건 번호
        int[] from;
        if (a == 0) {
            from = (car == 1) ? new int[]{1, 1} : new int[]{n, n};
        } else {
            from = cases[a];
        }
        int[] to = cases[b];
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }

    public static int[] calminlength(int[][] cases, int w, int n) {
        int[] ans = new int[w + 1];
        ans[0] = Integer.MAX_VALUE;
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        int[][] parent = new int[w + 1][w + 1];
        int[][] choice = new int[w + 1][w + 1];

        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= w; j++) {
                int casenum = Math.max(i, j) + 1;
                if (casenum > w) continue;
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                // 1번 차가 casenum 처리
                int newCost = Math.min(dp[casenum][j], dp[i][j] + dist(i, casenum, cases, n, 1));
                if (newCost < dp[casenum][j]) {
                    dp[casenum][j] = newCost;
                    parent[casenum][j] = i;      // (이전 i 저장)
                    choice[casenum][j] = 1;
                }

                // 2번 차가 casenum 처리
                newCost = Math.min(dp[i][casenum], dp[i][j] + dist(j, casenum, cases, n, 2));
                if (newCost < dp[i][casenum]) {
                    dp[i][casenum] = newCost;
                    parent[i][casenum] = j;      // (이전 i 저장)
                    choice[i][casenum] = 2;
                }
            }
        }
        int x = 0, y = 0;

        for (int i = 0; i <= w; i++) {
            if (ans[0] > dp[w][i]) {
                ans[0] = dp[w][i];
                x = w;
                y = i;
            }
            if (ans[0] > dp[i][w]) {
                ans[0] = dp[i][w];
                x = i;
                y = w;
            }
        }

        for (int i = 0; i < w; i++) {
            if (choice[x][y] == 1) {
                ans[w-i] = 1;
                x = parent[x][y];
            }
            else {
                ans[w-i] = 2;
                y = parent[x][y];
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int w = Integer.parseInt(br.readLine());
        int[][] cases = new int[w + 1][2];
        dp = new int[w + 1][w + 1];

        for (int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cases[i] = new int[]{x, y};
        }

        int[] ans = calminlength(cases, w, n);
        for (int i = 0; i < w+1; i++) {
            bw.write(ans[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
