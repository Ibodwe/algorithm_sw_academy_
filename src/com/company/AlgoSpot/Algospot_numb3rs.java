package com.company.AlgoSpot;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_numb3rs {


    static int[][] map;
    static int [] answer;
    static int [] townNum;
    static int n;
    static int d;
    static int p;

    static double [][] checkMap;

    static public double getPath(int currentPosition, int day) {

        if (day == 0) {
            if (currentPosition == p) {

                return  1;
            }
            return 0;
        }

        if (checkMap[currentPosition][day] != -1) {
            return checkMap[currentPosition][day];
        }

        double num = 0.0;


        for (int i = 0; i < map[currentPosition].length; i++) {

            if (map[currentPosition][i] == 1) {
                num += getPath(i, day - 1) / townNum[i];
            }
        }
        checkMap[currentPosition][day] = num ;


        return checkMap[currentPosition][day];
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int c = Integer.parseInt(st.nextToken());


        for(int i =0; i<c; i++){
            st = new StringTokenizer(br.readLine()," ");
             n = Integer.parseInt(st.nextToken());
             d = Integer.parseInt(st.nextToken());
             p = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            townNum = new int [n];
            checkMap = new double[n][d+1];

            for(int j=0; j<n; j++){

                st = new StringTokenizer(br.readLine(), " ");
                int count = 0;

                for(int k =0; k<n; k++){

                    map[j][k] = Integer.parseInt(st.nextToken());
                    if(map[j][k]==1)
                        count++;
                }
                townNum[j] = count;
            }

            for(int j =0; j<n; j++){
                for(int k =0; k<=d; k++){
                    checkMap[j][k] = -1;
                }
            }

            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());

            answer = new int [t];
            st = new StringTokenizer(br.readLine(), " ");

            for(int j =0; j<t; j++){
                answer[j] = Integer.parseInt(st.nextToken());
                System.out.print(String.format("%.8f",getPath(answer[j],d)) +" ");
         }
            System.out.println();

        }
    }

}
