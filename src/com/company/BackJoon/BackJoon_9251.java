package com.company.BackJoon;



import java.util.Scanner;

public class BackJoon_9251 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a =  sc.nextLine();
        String b = sc.nextLine();

        int [][] dp = new int[a.length()+1][b.length()+1];

        for(int i =1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] =dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//        for(int i =0; i<=a.length(); i++){
//            for(int j=0; j<=b.length(); j++){
//                System.out.print(dp[i][j] +" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[a.length()][b.length()]);
    }

}

