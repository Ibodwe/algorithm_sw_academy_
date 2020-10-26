package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_picnic {


    static int [][] map;
    static boolean[] isvisited;
    static int friendNum;
    static int student;
    static int answer = 0 ;

    static public void searchFriend(){

        int First = -1;

        for(int i =0; i<student; i++){
            if(!isvisited[i]){
                First = i;
                break;
            }
        }

        if(First==-1){
            answer++;
            return;
        }
       // System.out.println("First " + First);
        for(int i =First+1; i<student; i++){

            if(!isvisited[i] && map[First][i] == 1){
                isvisited[i] = true;
                isvisited[First] =true;
                searchFriend();
                isvisited[i] = false;
                isvisited[First] =false;
            }
        }


    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int C = Integer.parseInt(st.nextToken());

        for(int index = 0; index <C; index++ ){

             st = new StringTokenizer(br.readLine()," ");

             student = Integer.parseInt(st.nextToken());
             friendNum = Integer.parseInt(st.nextToken());
             answer =0;

             map = new int[student][student];
             isvisited = new boolean[student];

            st = new StringTokenizer(br.readLine()," ");

            for(int i =0; i<friendNum; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
                map[b][a] = 1;
            }
            searchFriend();

            System.out.println(answer);
        }


    }
}
