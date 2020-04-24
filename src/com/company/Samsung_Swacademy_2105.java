package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Samsung_Swacademy_2105 {

    static int[][] dir = {{1,1},{-1,1},{-1,-1},{1,-1}};
    static int N;
    static Stack<Integer> st = new Stack<>();
    static Boolean[][] check;
    static Boolean[] checkNum;
    static int answer;
    static int count;
    static int map[][];
    public static boolean isValid(int a, int b){
        if(a<0 || a>=N || b<0 || b>=N ){
            return false;
        }
        return true;
    }



    public static void dfs(int x,int y){


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int n = 1; n<= 10; n++){
             N = sc.nextInt();
             answer = 0;

            map = new int [N][N];

            for(int i =0; i<N; i++){
                for(int j =0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i =0; i<N; i++){
                for(int j =0; j<N; j++){
                    check = new Boolean[N][N];
                    checkNum = new Boolean[101];
                    count=0;
                    dfs(i,j);
                }
            }

            System.out.println("#" +n + " " + answer);

        }
    }
}
