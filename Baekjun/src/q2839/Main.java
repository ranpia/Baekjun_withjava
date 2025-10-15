package q2839;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Dp d = new Dp(sc.nextInt());

        System.out.println(d.dpsugar());

    }
}

class Dp {
    public static int sugar;
    private int basketcounts;


    Dp(int sugar){
        this.sugar = sugar;
    }

    public int dpsugar(){
        if (sugar < 3 || sugar == 4) return -1;
        if (sugar == 5 || sugar == 3) return 1;

        int [] dp = new int [5006];
        Arrays.fill(dp,-1);

        dp[3]=1;
        dp[5]=1;
        int idx = 6;
        while (basketcounts < 1){
            if (dp[idx-3]>0 && dp[idx-5]>0){
                dp[idx] = Math.min(dp[idx - 3], dp[idx - 5]) + 1;
            }
            else if (dp[idx-3]>0){
                dp[idx] = dp[idx - 3]+1;
            }
            else if (dp[idx-5]>0){
                dp[idx] = dp[idx - 5]+1;
            }

            if (idx == sugar){
                if (dp[idx]>0){
                    basketcounts = dp[idx];
                }
                else {
                    basketcounts = -1;
                    break;
                }

            }
            idx++;
        }

        return basketcounts;
    }
}