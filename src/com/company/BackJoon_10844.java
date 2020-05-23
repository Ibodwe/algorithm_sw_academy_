package com.company;

import java.util.Scanner;

public class BackJoon_10844 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int [] map = new int[t];
        int [] an = new int [t];

        for(int i =0; i<t; i++){
            map[i] = sc.nextInt();
            an[i] =1;
        }


        for(int i =0; i<t; i++){
          int start = map[i];
          for(int j =0; j < i; j++){
              if(start > map[j]){
                  an[i] = Math.max(an[i], an[j] + 1);
              }
          }
        }

        int big = 1;
        int answer = 1;

        for(int i =0; i<t; i++){
            if(big < an[i]){
                big = an[i];
                answer = an[i];
            }
        }

        System.out.println(answer);

    }

}
