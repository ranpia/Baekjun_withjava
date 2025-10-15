package q1520;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

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
        bw.write(Integer.toString(pf.findpath()));

        bw.flush();
        bw.close();
        br.close();
    }
}

class Pathfinder {
    static int[][] map;

    Pathfinder(int[][] map) {
        this.map = map;
    }

    public int findpath(){
        int pathcounts = 0 ;

        boolean [][] visit = new boolean [map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(visit[i], false);
        }
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            if (x == map.length-1 && y == map[0].length-1){
                pathcounts++;
            }
            if (x>0){
                if (!visit[x - 1][y] && map[x][y] > map[x - 1][y] ){
                    q.add(new int[]{x - 1,y});
                }
            }
            if (y>0){
                if (!visit[x][y - 1] && map[x][y] > map[x][y-1] ){
                    q.add(new int[]{x,y - 1});
                }
            }
            if (y<map[0].length-1){
                if (!visit[x][y + 1] && map[x][y] > map[x][y+1] ){
                    q.add(new int[]{x,y + 1});
                }
            }
            if (x<map.length-1){
                if (!visit[x + 1][y] && map[x][y] > map[x+1][y] ){
                    q.add(new int[]{x + 1,y});
                }
            }
        }

        return pathcounts;
    }
}