package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_BOARDCOVER2 {

    static boolean [][] map;

    static int [][][] blocks;

    //제일 기본적 으로 나오는 좌표들
    static void getBlocksCoord(int R , int C ){

//        for(int i =1; i <R; i ++){
//            blocks[0][]
//        }

        for(int i=1 ; i<C; i++){

        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int i =0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map  = new boolean [H][W];

            //init map
            for(int j=0; j<H; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<W; k++){
                    char value = st.toString().charAt(i);
                    if(value=='#'){
                        map[j][k]= false;
                    }else{
                        map[j][k] = true;
                    }
                }
            }

            blocks = new int [8][R+C][2];
        }


    }
}
