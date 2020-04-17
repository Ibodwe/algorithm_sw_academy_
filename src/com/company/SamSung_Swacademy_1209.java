
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *
 2차원 배열과 연산
 문제를 정확히 이해 하는 것이 중요하다.
 정렬을 어떤 기준을 할 지 / 그리고 어떻게 출력을 할 것인가에 대해서 고밀해볼 것.
 Compareable을 이용해서 숫자와 숫자가 나오는 횟수를 통해 정렬을 함.
 시간은 넉넉한 편 .
 시간 1~2시간 사이 소요
 *
 */
public class SamSung_Swacademy_1209 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int k=1; k<=10; k++){

            int [][] map = new int[100][100];

            int answer = 0;

            int a =   sc.nextInt();

            for(int i=0; i<100; i++){
                for(int j =0; j< 100; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            //가로 세로 합
            for(int i=0; i<100; i++){
                int sum = 0;
                int sum2 = 0;
                for(int j =0; j< 100; j++){
                    sum += map[i][j];
                    sum2 += map[j][i];
                }
                answer = Math.max(sum,answer);
                answer = Math.max(sum2,answer);
            }

            //대각선의 합
            int sum =0;
            for(int i =0; i< 100; i++){
                sum+= map[i][i];
            }
            answer = Math.max(sum,answer);

            sum = 0;
            for(int i  = 99 ,j=0; i>=0; i-- ,j++){
                sum+= map[j][i];
            }
            answer = Math.max(sum, answer);


            System.out.println("#"+k +" " +answer);

        }
    }




}