package com.company.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_1965 {



    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] map = new int[N];
        int[] dp = new int [N];
        dp[0] = 1;

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i< N ; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i< N; i++){
            int targetNum = map[i];
            int maxNum = 0;

            for(int j =0; j < i; j++){
                //max 값 구하고
                if(map[j]<targetNum) {
                    maxNum = Math.max(maxNum, dp[j]);
                }
            }
            dp[i] = maxNum + 1;
        }

        Arrays.sort(dp);

        System.out.println(dp[0]);





    }

}