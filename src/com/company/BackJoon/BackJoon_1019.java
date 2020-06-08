package com.company.BackJoon;

import java.util.Scanner;

public class BackJoon_1019 {


    static int num;
    static int miniMun;
    static int len;
     static boolean p;
     static int answer = 999999;
     static  boolean [] rem;
  static public void makeNum(int value, int n, int count ){


        if(count==n){

            //    System.out.println(value);

            int v = Math.abs(value - num);
          //    System.out.println("v " + v);

            if(v <= miniMun){
                miniMun = v;
                len = value;
                int t = Math.abs(num -len);
                answer = Math.min(t +n,answer);

            }else{
                 p = false;
                return;

            }
            return;
        }

        for(int i =0; i<10; i++){
            if(!rem[i]){
                if(value==0 && i==0){
                    continue;
                }else{
                    makeNum(value*10+i, n,count+1);
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       rem = new boolean[10];
        num = sc.nextInt();
        miniMun =5000011;
        int n = sc.nextInt();
        int count = 0;

        for(int i =0; i<n ; i++){
            int k = sc.nextInt();
            count++;
            rem[k] = true;
        }

        p= true;
        int l =1;

        int sNum = Math.abs(100-num);

        if(count==10){
            System.out.println(sNum);
        }else if(count==9 && !rem[0]) {

            if(num + 1 < sNum){
                System.out.println(num + 1);
            }else{
                System.out.println(sNum);
            }

        }else{
        while(p){
            makeNum(0,l,0);
            l++;
        }

        if(sNum < answer){
            System.out.println(sNum);
        }else{
            System.out.println(answer);
        }

        }

        //제일 가까운 수 만들 어서..! ++ 또는 -- 하면 됨..!
        // 제일 가까운 수를 어떻게 만들것인가..!
        //1

    }
}
