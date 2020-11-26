package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

public class Algospot_snail {


    static int n = 0;
    static int m = 0;
    static double [][] answer;


    static public double solve(int m, int n){
        //m 이 날짜
        //n 이 우물 높이

        if(n<=0){
            return 1;
        }
        if(m<=0){
            return 0;
        }

        double res = answer[m][n];

        if(res!=-1){
            return res;
        }

        answer[m][n] = solve(m-1,n-2)*0.75 + solve(m-1,n-1)*0.25;

        return answer[m][n];
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int t = Integer.parseInt(st.nextToken());

        for(int i =0; i<t; i ++){

            st = new StringTokenizer(br.readLine(), " ");
             n = Integer.parseInt(st.nextToken());
             m = Integer.parseInt(st.nextToken());

             answer = new double[m+1][n*2+1];


             for(int j =0; j<m+1; j++){
                 for(int k =0; k<n*2+1; k++){
                     answer[j][k] = -1;
                 }
             }

            System.out.println(String.format("%.10f",solve(m,n)));

            for(int j =0; j<m+1; j++){
                for(int k =0; k<n*2+1; k++){
                        System.out.println("j " + j + " k " + k +" " + answer[j][k]);
                }
            }

            System.out.println();


        }

    }
}
