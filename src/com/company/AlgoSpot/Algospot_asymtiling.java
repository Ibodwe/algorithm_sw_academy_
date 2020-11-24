package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_asymtiling {


   static int[] normalTile;

   static int c = 0;

   static int mod = 1000000007;

   static public int seTile(int n){

      // System.out.println("setTile");
       if(n<=1){
           return 1;
       }

       if(normalTile[n]!= -1){
           return normalTile[n];
       }
       normalTile[n] = (seTile(n-1) + seTile(n-2))% mod;

     //  System.out.println("n " +normalTile[n]);
       return normalTile[n];
   }

   static public int answer(int n ){

       if(n%2==1){
           return (normalTile[n] - normalTile[n/2] + mod) % mod;
       }

       int res = normalTile[n];

       res = (res - normalTile[n/2] +mod) % mod;
       res = (res - normalTile[n/2-1] +mod) % mod;
      // System.out.println("Last res " + res);
       return res;
   }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(),"");

        int t = Integer.parseInt(st.nextToken());

        for(int i =0; i<t; i ++){
            st = new StringTokenizer(br.readLine());
             c = Integer.parseInt(st.nextToken());
            normalTile = new int [c+1];

            for(int j =0; j<=c; j++){
                normalTile[j] = -1;
            }
            normalTile[0] = 1;
            normalTile[1] = 1;

            seTile(c);

            System.out.println(answer(c));

        }


    }

}
