package com.company.SamSung;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SamSung_Swacademy_5644 {


    static public int getRange(int x1, int y1, int x2, int y2){
        return Math.abs(y2-x1) + Math.abs(y1-x2);
    }

    static int answer;
    static int [][] dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int mm =1 ; mm<=T ; mm++){

            answer = 0;
            int M = sc.nextInt();
            int A = sc.nextInt();

            int peopleAx = 1;
            int peopleAy = 1;
            int peopleBx = 10;
            int peopleBy = 10;

            ArrayList<AP> apMap = new ArrayList<>();

            int[] peopleA = new int[M];
            int[] peopleB = new int[M];

            for(int i=0; i<M; i++){
                peopleA[i] = sc.nextInt();
            }
            for(int i=0; i<M; i++){
                peopleB[i] = sc.nextInt();
            }

            for(int i =0; i<A; i++){
                int x= sc.nextInt();
                int y = sc.nextInt();
                int range = sc.nextInt();
                int power = sc.nextInt();
                apMap.add(new AP(x,y,range,power));
            }

            Collections.sort(apMap);
            for(int i =0; i<=M; i++){

                int[] checkMap = new int [A];
               System.out.println(peopleAx + " " + peopleAy +" " + peopleBx + " " + peopleBy);
                for(int j=0; j<apMap.size(); j++){
                    int value = getRange(peopleAx,peopleAy,apMap.get(j).x,apMap.get(j).y);

                    if(value <= apMap.get(j).range){
                            checkMap[j] += 1;
                    }

                    int value2 = getRange(peopleBx,peopleBy, apMap.get(j).x,apMap.get(j).y);

                    if(value2 <= apMap.get(j).range){
                        checkMap[j] += 2;
                    }
                }

                //현재 위치 에서 A B가 사용 할 수 있는 배터리의 표 조합
                int maxValue1 = 0;
                int maxValue2 = 0;
                for(int j=0; j<A; j++){
                    if(checkMap[j]==1){
                        maxValue1 = Math.max(maxValue1,apMap.get(j).power);
                    }else if(checkMap[j]== 2){
                        maxValue2 = Math.max(maxValue2,apMap.get(j).power);
                    }
                }

                for(int j=0; j<A; j++){
                    if(checkMap[j]== 3){
                        //더 낮은 값을 가진 친구가..!
                        if(maxValue1 < maxValue2){
                            maxValue1 = Math.max(maxValue1,(apMap.get(j).power));
                        }else{
                            maxValue2 = Math.max(maxValue2,(apMap.get(j).power));
                        }
                    }
                }
                answer+=maxValue1;
                answer+=maxValue2;
                //System.out.println("value 1 " +maxValue1 +" value2 " +maxValue2 );

                if(i<M){

                peopleAx += dir[peopleA[i]][0];
                peopleAy += dir[peopleA[i]][1];

                peopleBx += dir[peopleB[i]][0];
                peopleBy += dir[peopleB[i]][1];

                }
            }
            apMap.clear();
          //  System.out.println("#"+mm +" " +answer);
        }

    }

    static class AP implements Comparable<AP>{
        int x;
        int y;
        int range;
        int power;
        public AP(int x, int y, int range, int power){
            this.x = x;
            this.y= y;
            this.range=range;
            this.power = power;
        }

        @Override
        public int compareTo(AP o) {
            return o.power-this.power;
        }
    }
}
