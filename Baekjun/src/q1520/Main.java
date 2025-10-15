package q1520;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int[][] map = new int [N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        Pathfinder pf = new Pathfinder(map);
        bw.write(Integer.toString(pf.dfs(0,0)));

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pathfinder {
    static int[][] map;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dp;

    Pathfinder(int[][] map) {
        this.map = map;
        this.dp = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) Arrays.fill(dp[i], -1);
        dp[map.length-1][map[0].length-1] = 1;
    }

    public int dfs(int nx, int ny) {
        if (dp[nx][ny] > -1){
            return dp[nx][ny];
        }

        int pathcounts = 0 ;
        for (int i = 0; i<dir.length; i++){
            int x =nx + dir[i][0];
            int y =ny + dir[i][1];
            if (x >= 0 && y >= 0 && y<map[0].length && x<map.length){
                if (map[nx][ny] > map[x][y] ){
                    pathcounts += dfs(x,y);
                }
            }
        }
        dp[nx][ny] = pathcounts;
        return pathcounts;
    }
}