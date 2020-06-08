package com.company.BackJoon;

import java.util.*;


public class BackJoon_11055 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] sample = new int[n];
        int [] map = new int [n];

        for(int i =0; i < n ;i++){
            sample[i] = sc.nextInt();
        }

        for(int i =0; i < n; i++ ){
            map[i] = sample[i];
            int num = sample[i];
            //     System.out.println("num " + num);
            for(int j = i; j>=0; j-- ){
                if(num > sample[j]){

                    map[i] = Math.max(sample[i] + map[j],map[i]);
                }
            }
            //   System.out.println(i+" " + map[i]);
        }
        int answer = 0;

        for(int i =0; i<n; i++){
            if(answer < map[i]){
                answer= map[i];
            }
        }

        System.out.println(answer);
    }






}
