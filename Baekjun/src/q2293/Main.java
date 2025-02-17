package q2293;

import java.util.Scanner;
import java.util.Arrays;

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
        c.coincount(new int[coinnum], goal, 0);
        System.out.println(c.casesCount);
    }
}

class CoinCase {
    public int casesCount;
    public int[][] coinCases;
    public int[] coins;

    public CoinCase(int[] coins) {
        this.coins = coins;
        this.coinCases = new int[1000][coins.length]; // 충분한 크기로 초기화
        this.casesCount = 0;
    }

    public void coincount(int[] usedcoins, int goal, int cur_mount) {		
        if (cur_mount > goal) {
            return;
        } else if (cur_mount == goal) {
            boolean dupli = false;
            for (int i = 0; i < casesCount; i++) {
                if (Arrays.equals(this.coinCases[i], usedcoins)) {
                    dupli = true;
                    return;
                }
            }
            if (!dupli) {
                this.coinCases[casesCount] = Arrays.copyOf(usedcoins, usedcoins.length);
                this.casesCount++;
            }
            return;
        } else {
            for (int i = 0; i < coins.length; i++) {
                usedcoins[i]++;
                coincount(usedcoins, goal, cur_mount + this.coins[i]);
                usedcoins[i]--; // 백트래킹 추가
            }
        }
    }
}
