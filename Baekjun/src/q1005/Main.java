package q1005;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) adj[j] = new ArrayList<>();

            int[] buildcosts = new int[n];
            String[] str = br.readLine().split(" ");
            for (int j=0; j<n;j++) {
                buildcosts[j] = Integer.parseInt(str[j]);
            }

            int [] input = new int[n];
            for (int j=0; j<k;j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[x].add(y);
                input[y-1]++;
            }

            int goal = Integer.parseInt(br.readLine());
            ACMCraft ac = new ACMCraft(n, k, buildcosts, adj, goal, input);

            bw.write(Integer.toString(ac.timeToGoal()));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class ACMCraft{
    private int n;
    private int k;
    private int[] cost;
    private ArrayList<Integer>[] adj;
    private int goal;
    private int[] input;

    ACMCraft(int n, int k, int[] cost, ArrayList<Integer>[] adj, int goal, int[] input){
        this.n = n;
        this.k = k;
        this.cost = cost;
        this.adj = adj;
        this.goal = goal;
        this.input = input;
    }

    public int timeToGoal(){
        int totaltime = 0;
        int[] timetobuild = new int [n];

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i< input.length;i++) {
            if (input[i]==0){
                que.add(i+1);
                timetobuild[i] = cost[i];
            }
        }
        while (!que.isEmpty()){
            int curver = que.poll();

            if (curver == goal){
                totaltime = timetobuild[curver-1];
                break;
            }
            else {
                ArrayList<Integer> edges = adj[curver];
                if (!edges.isEmpty()){
                    for (int i: edges){
                        timetobuild[i-1] = Math.max(timetobuild[i-1], cost[i-1] + timetobuild[curver-1]);
                        if (--input[i-1]==0){que.add(i);}
                    }
                }
            }
        }

        return totaltime;
    }
}