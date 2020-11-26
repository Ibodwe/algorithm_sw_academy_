package com.company.SamSung;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Scpc1 {




    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i =1; i<=t ; i ++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int [] launch = new int [n];
            int [] dinner = new int [n];

            st = new StringTokenizer(br.readLine()," ");

            for(int j =0; j <n;j++){
                launch[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(launch);

            st = new StringTokenizer(br.readLine()," ");

            for(int j =0; j <n;j++){
                dinner[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(dinner);

            //첫번 째 아이디어 --> k 개수 만큼 제한

            int answer = 0;

            for(int num =0; num<k; num++){

                answer = Math.max(answer,launch[num] + dinner[k-num-1]);

            }

            System.out.println("Case #" +i);
            System.out.println(answer);

            //k일 동안 최대 칼로리가 적게




        }


    }
}


