package com.company.SamSung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.util.ServiceConfigurationError;

public class SamSung_Swacademy_1210 {

    static int map [][];

    static Queue<Integer> queue = new LinkedList<>();

    static int[][] dir = {{0,1},{0,-1},{-1,0}};
    static boolean[][] check;
    static int answer = 0;
    static public void dfs(int a, int b){
        check = new boolean[100][100];
        queue.add(a);
        queue.add(b);
        //사다리 탔는지 안탔는지 알아보는거
        boolean isLaddering = false;

        int curdir =0;
        check[a][b] = true;

        while (!queue.isEmpty()){
            int x = queue.peek();
            queue.poll();
            int y = queue.peek();
            answer =y;
            queue.poll();
            for(int i=0; i<3; i++){
                int x1 = x + dir[i][0];
                int y1 = y + dir[i][1];

                if(isValid(x1,y1) && map[x1][y1]==1 && check[x1][y1]==false){
                    check[x1][y1]=true;
                    queue.add(x1);
                    queue.add(y1);
                    break;
                }
            }
        }


    }



    static public boolean isValid(int a, int b){
        if(a<0 || a>=100 || b<0 ||  b>=100){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i =1 ; i<=10; i++){
            String[] a = sc.nextLine().split(" ");

            map = new int[100][100];

            for(int j=0; j<100; j++){
                String [] number = sc.nextLine().split(" ");
                for(int k=0; k<number.length; k++){
                    map[j][k] = Integer.parseInt(number[k]);
                }
            }

            for(int j=0; j<100; j++){
                if(map[99][j]==2){
                    dfs(99,j);
                    break;
                }
            }
            System.out.println("#"+i+" " +answer);

        }

    }

}

