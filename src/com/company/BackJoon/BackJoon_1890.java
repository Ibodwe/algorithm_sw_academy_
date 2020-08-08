package com.company.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1890   {


    static int [][] map;
    static long [][] dp;
    static int n;
    public static long dfs(int i, int j ){



        if(i==n-1 && j ==n-1){
            return 1;
        }

        if(map[i][j]==0){
            return 0;
        }

        if(dp[i][j]>0){
            return dp[i][j];
        }



        int num = map[i][j];
        //오른쪽 또는 아래쪽으로 이동 ..!

        if(i+num >=0 && j>= 0 && i+num < n && j < n){
            dp[i][j] += dfs(i+num,j);
        }

        if(i >=0 && j+num>= 0 && i < n && j+num < n){
            dp[i][j] += dfs(i,j+num);
        }


        return dp[i][j];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());

        map = new int [n][n];
        dp = new long [n][n];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long k  = dfs(0,0);
        System.out.println(k);




    }
}
