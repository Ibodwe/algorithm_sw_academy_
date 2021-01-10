package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Algospot_LUNCHBOX {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int C = Integer.parseInt(st.nextToken());

        for(int i =0; i<C; i++) {
            st = new StringTokenizer(br.readLine(), "");
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()," ");

            int [][] arr = new int [t][2];
            for(int j =0; j< t; j++){
                arr[j][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()," ");

            for(int j =0; j< t; j++){
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });


            int heatTimer =0;
            int answer = 0;

           for(int j=0; j<t; j++){
               answer = Math.max(answer, heatTimer + arr[j][0] + arr[j][1]);
               heatTimer += arr[j][0];


           }

            System.out.println(answer);

        }
    }


}