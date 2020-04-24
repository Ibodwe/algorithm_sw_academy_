package com.company;

import java.util.Scanner;

public class BaekJoon_1149 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [][] map = new int [N][3];
        int [][] answer = new int [N][3];

        for(int i =0; i<N; i++){
            for(int j=0; j<3; j++){
                map[i][j] = sc.nextInt();
            }
        }

        answer[0][0] = map[0][0];
        answer[0][1] = map[0][1];
        answer[0][2] = map[0][2];


        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                switch (j){
                    case 0:
                        answer[i][j] = Math.min(map[i][j]+answer[i-1][1], map[i][j]+answer[i-1][2]);
                        break;
                    case 1:
                        answer[i][j] = Math.min(map[i][j]+answer[i-1][0], map[i][j]+answer[i-1][2]);
                        break;
                    case 2:
                        answer[i][j] = Math.min(map[i][j]+answer[i-1][1], map[i][j]+answer[i-1][0]);
                        break;
                }
            }
        }


        int va = Math.min(answer[N-1][0],answer[N-1][1]);
        va = Math.min(va,answer[N-1][2]);

        System.out.println(va);



    }
}
