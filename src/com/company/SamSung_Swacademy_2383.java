package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SamSung_Swacademy_2383 {

    static int cal(int x1, int y1, int x2,int y2 ){

        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int j=1; j<=T; j++){
            int N = sc.nextInt();

            int[][] map = new int [N][N];
            int count = 0;
            //계단 1과 계단 2의 기다리는 사람 수
            int st1Num = 0;
            int st2Num = 0;

            ArrayList<stair> st = new ArrayList<>();
            ArrayList<Pepole> peo = new ArrayList<>();
            Queue<Integer> st1 = new LinkedList <Integer>();
            Queue<Integer> st2 = new LinkedList<Integer>();

            //초기 셋팅완료
            for(int i=0; i<N; i++){
                for(int k =0; k< N; k++){
                    map[i][k] = sc.nextInt();
                    if(map[i][k]>1){
                        st.add(new stair(i,k));
                    }
                    if(map[i][k]==1){
                        count++;
                        peo.add(new Pepole(i,k,0,0));
                    }
                }
            }

            int value = map[st.get(0).x][st.get(0).y];
           //일단 계단을 빈 곳으로 만듬
            for(int i =0; i<value; i++){

                st1.add(0);

            }

             value = map[st.get(1).x][st.get(1).y];
            for(int i =0; i < value; i++){

                st2.add(0);

            }

            for(int i =0; i < peo.size(); i++){
                int dis1 = cal(peo.get(i).x,peo.get(i).y, st.get(0).x,st.get(0).y);
                int dis2 = cal(peo.get(i).x,peo.get(i).y, st.get(1).x,st.get(1).y);

                peo.set(i,new Pepole(peo.get(i).x,peo.get(i).y, dis1,dis2));
            }

            int time = 1;
            while(count < 0){
                boolean ch = false;

                for(int i =0; i < peo.size(); i++){
                    if(peo.get(i).stair1==time){
                        //어떤 계단 으로 갈지 --> 거리 + 계단의 길이 + 계단 에서 대기 하는 인원 수
                        int time1 = peo.get(i).stair1 + map[st.get(0).x][st.get(0).y]+ st1Num;
                        int time2 = peo.get(i).stair2 + map[st.get(1).x][st.get(1).y] + st2Num;
                        if(time1 < time2){

                            ch=true;
                        }
                    }
                    if(peo.get(i).stair2==time){
                        //어떤 계단 으로 갈지 --> 거리 + 계단의 길이 + 계단 에서 대기 하는 인원 수
                        int time1 = peo.get(i).stair1 + map[st.get(0).x][st.get(0).y] + st1Num;
                        int time2 = peo.get(i).stair2 + map[st.get(1).x][st.get(1).y] + st2Num;
                        if(time1 > time2){

                            ch=true;
                        }
                    }

                    if(ch){
                        peo.remove(i);
                    }
                }



                time++;

            }


        }


    }

    static class stair{
        int x;
        int y;
        public stair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Pepole{
        int x;
        int y;
        int stair1;
        int stair2;
        public Pepole(int x, int y,  int stair1,int stair2){
            this.stair1 = stair1;
            this.stair2 = stair2;
            this.x = x;
            this.y= y;
        }

    }
}
