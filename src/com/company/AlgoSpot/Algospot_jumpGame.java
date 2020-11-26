package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_jumpGame {

    static int [][] map;
    static boolean [][] visitedMap;
    static int m;
    public static void main(String[] args) throws Exception {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");


        System.out.println();
        int t = Integer.parseInt(st.nextToken());

        for(int i =0; i<t; i++){
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            visitedMap = new boolean[m][m];

            map = new int [m][m];

            //init Map
            for(int j =0; j<m; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<m; k++){
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            search(0,0);

            if(visitedMap[m-1][m-1]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }


    }

    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static public void search(int x, int y) {

        //기저 조건
        if(x < 0 || x >= m || y < 0 || y >= m){
            return;
        }

        if(visitedMap[x][y]){
            return;
        }

        visitedMap[x][y] = true;

        search(x,  y + map[x][y]);
        search(x + map[x][y], y);

    }
}
