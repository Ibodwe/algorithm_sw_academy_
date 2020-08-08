package com.company.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

public class BackJoon_11054   {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());

        int [] map = new int [n];
        int [] dp= new int [n];
        int [] dp2 = new int [n];

        //0은 작은 값 중에서 왼쪽에서 온 애들
        //1은 작은 값 중에서 오른쪽에서 온 애들
        st = new StringTokenizer(br.readLine()," ");

        for(int i =0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
            dp[i]=1;
            dp2[i]=1;
        }

        for(int i =0; i<n-1; i++){
            int max1 = 0;
            for(int j = 0; j < i; j++){
                if(map[j] < map[i]){
                    max1 = Math.max(max1 , dp[j]);
                }
            }
            dp[i] = max1+1;
            //  System.out.println(dp[i]+" first ");

        }

        for(int i =n-1; i > 0; i--){
            int max2 = 0;
            for(int j = n-1; j > i; j--){
                if(map[j] < map[i]){
                    max2 = Math.max(max2 , dp2[j]);
                }
            }
            dp2[i] = max2+1;
            //  System.out.println(dp[i]+" second ");

        }

        int answer = 0;

        for(int i =0; i<n; i++){
            System.out.print(dp[i]+" ");
            answer = Math.max(answer,dp[i]+dp2[i]);
        }

        System.out.println();
        for(int i =0; i<n; i++){
            System.out.print(dp2[i]+" ");
        }

        System.out.println(answer-1);

    }
}
