package q2293;

import java.util.Scanner;

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

		CoinCase c = new CoinCase(coins, goal);
		c.coincount();
		System.out.println(c.casesCount);
	}
}

class CoinCase {
	public int casesCount;
	public int[] coins;
	public int[] dp;
	public int goal;

	public CoinCase(int[] coins, int goal) {
		this.coins = coins;
		this.casesCount = 0;
		this.dp = new int[goal + 1];
		this.goal = goal;
	}

	public void coincount() {
		// 초기값 세팅
		dp[0] = 1;

		// 중복 제거 로직 추가하기
		for (int coin : coins) {
			for (int i = coin; i < dp.length; i++) {
				dp[i] += dp[i - coin];
				System.out.print("dp[" + (i) + "] : " + dp[i]);
				System.out.println("+ dp[" + (coin) + "] : " + dp[coin]);

			}
		}
		casesCount = dp[goal];
	}
}
