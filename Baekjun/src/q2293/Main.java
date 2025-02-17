package q2293;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinnum = sc.nextInt();
        int goal = sc.nextInt();

        int[] coins = new int[coinnum];
        for (int i = 0; i < coinnum; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        CoinCase c = new CoinCase(coins);
        c.coincount(new int[coinnum], goal);
        System.out.println(c.casesCount);
    }
}

class CoinCase {
    public int casesCount;
    public ArrayList<int[]> coinCases;
    public int[] coins;

    public CoinCase(int[] coins) {
        this.coins = coins;
        this.coinCases = new ArrayList<>();
        this.casesCount = 0;
    }

    public void coincount(int[] usedcoins, int goal) {
        int cur_mount = 0;
        for (int i = 0; i < coins.length; i++) {
            cur_mount += this.coins[i] * usedcoins[i];
        }

        if (cur_mount > goal) {
            return;
        } else if (cur_mount == goal) {
            for (int[] caseArr : this.coinCases) {
                if (Arrays.equals(caseArr, usedcoins)) {
                    return; // 중복이면 바로 종료
                }
            }
            this.coinCases.add(Arrays.copyOf(usedcoins, usedcoins.length));
            this.casesCount++;
            return;
        } else {
            for (int i = 0; i < coins.length; i++) {
                usedcoins[i]++;
                coincount(usedcoins, goal);
                usedcoins[i]--; // 백트래킹 추가
            }
        }
    }
}
