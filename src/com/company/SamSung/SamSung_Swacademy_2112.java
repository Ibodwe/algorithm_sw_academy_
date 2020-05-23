package com.company.SamSung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SamSung_Swacademy_2112 {

    static int D;
    static int W;
    static int K;
    static int [][] map;
    static int [] nmap = new int [13];
    static int[] nmap2 = new int [13];
    static  int[][] map2;
    static int answer= 0;
    static boolean p;

    //K개 검사를 통과하는지
    static public boolean check(int [][] map){

        for(int i =0; i<W; i++){
            int count = 0;
            int num = map[0][i];
            int maxCount = 0;
            for(int j=0; j < D; j++){

                if(num==map[j][i]){
                    count++;
                }else{
                    maxCount = Math.max(count, maxCount);
                    num = map[j][i];
                    count = 1;
                }
            }
             maxCount = Math.max(count,maxCount);

            if(maxCount < K){

                return false;
            }
        }
        return true;
    }
    // 1개부터 K개 까지 뽑는 방법..!

    static public void make(int n,int count, int index,int start){
        //1개씩 뽑기
       // System.out.println("makek");
        if(count==n){
                make2(n,0);
            return;
        }

        for(int i =start; i<D; i++){
            int value = 1<<i & index;

            if(value==0){
                nmap[count] = i;
                make(n,count+1,1<<i|index, i);
            }
        }

    }

    //0과 1로 만들 수 있는 조합..!

    static public void make2(int n, int count){

        if(count == n ){
            map2 = new int[D][W];
            for(int  i=0; i<D; i++){
                for(int j =0; j<W; j++){
                    map2[i][j] = map[i][j];
                }
            }

            //행 변화 시키는 물약..!
            for(int i=0; i<n; i++){
                if(nmap2[i]==0){
                    medicine(0,nmap[i]);
                }else{
                    medicine(1,nmap[i]);
                }
            }

          boolean a = check(map2);

            if(a){
                answer = n;
                p = true;
                return;
            }
            return;
        }

        for(int i =0; i<2; i++){
            nmap2[count] = i;
            make2(n,count+1);
        }

    }

  static   public void medicine(int num, int x){
        for(int i =0; i<W; i++){
            map2[x][i] =num;
        }
    }









    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;

        int T = sc.nextInt();

        for(int n = 1; n<=T; n++){
            answer = 0;
             D = sc.nextInt();
             W = sc.nextInt();
             K = sc.nextInt();

             map= new int[D][W];

            for(int i =0; i<D; i++){
                for(int j=0; j<W; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            p = false;
            boolean a= check(map);
            for(int i=1; i< D; i++){

                if(a){
                    break;
                }else{
                    make(i,0,0,0);
                    if(p){
                        break;
                    }
                }
            }



            System.out.println("#" +n +" " + answer);
        }
    }
}
