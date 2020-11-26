package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
*   1. N만큼 사이즈에서 가장 작은 시작과 끝 index를 구한다.
*   2. N일 연속의 평균을 구한다
*   3. 시작과 끝 index의 값이 평균 보다 작다면 편입
*   4. 평균 업데이트
*   5. 2번 반복
* */
// 곱하고 나누어서 오차 발생 --> 해결 방안 필요
public class Algospot_festival {


    public static void main(String[] args) throws  Exception{

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int C = Integer.parseInt(st.nextToken());
        for(int c=0; c<C; c++){

            st = new StringTokenizer(br.readLine()," ");

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int [] map = new int [N];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i =0; i<N; i++){
                map[i] = Integer.parseInt(st.nextToken());
            }

            double minValue = 99999999;
            for(int i =0; i <N-L; i++){

                double temp =0;
                int count = L;

                for(int j = i; j <i + L; j++){
                    temp+= map[j];
                }

                //기본 --> 최소한의 개수
                double t = temp/L;

               // System.out.println("t1 " + t);

                for(int k = i-1; k >= 0; k--){

                    if(map[k] < t){
                        t =t*count;
                        t+= map[k];
                        count++;
                        t/=count;

                    }else{
                        break;
                    }
                }
            //    System.out.println("t222 " + t);

                for(int k = i+L; k<N; k++){
                //    System.out.println("map " + k+ " t " + t );
                    if(map[k] < t){
                        t = t*count;

                        t+= map[k];

                        count++;
                        t/=count;

                    }else {
                        break;
                    }
                }

                //System.out.println("t333 " + t);
                if(t < minValue){
                    minValue = t;
                }

            }



        System.out.println(String.format("%.12f",minValue));

        }


    }
}
