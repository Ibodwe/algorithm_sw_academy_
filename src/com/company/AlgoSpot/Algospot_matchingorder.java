package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algospot_matchingorder {

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int C = Integer.parseInt(st.nextToken());

        for(int i =0; i<C; i++){
            st = new StringTokenizer(br.readLine(),  "");
            int t=  Integer.parseInt(st.nextToken());

            int [] russianPlayer = new int[t];
            int [] koreanPlayer = new int [t];

            st= new StringTokenizer(br.readLine()," ");

            for(int j=0; j<t; j++){
                russianPlayer[j] = Integer.parseInt(st.nextToken());
            }

            st= new StringTokenizer(br.readLine()," ");

            for(int j=0; j<t; j++){
                koreanPlayer[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(russianPlayer);
            Arrays.sort(koreanPlayer);

            int a = 0;
            int b = 0;
            int answer = 0;

            while (a < t && b < t){
                if(russianPlayer[a] <= koreanPlayer[b]){
                      a++;
                      b++;
                      answer++;
                }else{
                    b++;
                }
            }
            System.out.println(answer);

        }

    }
}
