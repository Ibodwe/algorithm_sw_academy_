package com.company.SamSung;


import java.util.*;

public class SamSung_14499_BackJoon {
    static Queue<Integer> q;

    static int [][] dir = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
    static int N;
    static int M;
    static int[][] map;
    public static void move(int a, int b) {
        //동 서 북 남
        cube box = new cube(0,0,0,0,0,0);


        while (!q.isEmpty()) {
            int v = q.peek();
            q.poll();
            int na = a + dir[v][0];
            int nb = b + dir[v][1];
            //   System.out.println(a + " " + b);
            //    System.out.println(na+" " + nb+" " +v );

            if(isvalid(na,nb)){
                switch (v) {
                    case 1:
                        int temp = box.di1;
                        box.di1 = box.di4;
                        box.di4 = box.di6;
                        box.di6 = box.di3;
                        box.di3 = temp;
                        break;

                    case 2:
                        int temp2 = box.di1;
                        box.di1 = box.di3;
                        box.di3 = box.di6;
                        box.di6 = box.di4;
                        box.di4 = temp2;
                        break;

                    case 3:

                        int temp4 = box.di1;
                        box.di1= box.di5;
                        box.di5 = box.di6;
                        box.di6 = box.di2;
                        box.di2 = temp4;
                        break;

                    case 4:
                        int temp3 = box.di1;
                        box.di1 = box.di2;
                        box.di2 = box.di6;
                        box.di6 =box.di5;
                        box.di5 = temp3;
                        break;
                }

                if(map[na][nb]==0){
                    map[na][nb] = box.di6;
                }else{
                    box.di6 = map[na][nb];
                    map[na][nb] = 0;
                }
                a = na;
                b = nb;

                System.out.println(box.di1);

            }else{
                continue;
            }



        }


    }

    static boolean isvalid(int a ,int b){
        if(a<0 || a >= N || b < 0 || b >= M){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();

        q = new LinkedList<>();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int v = sc.nextInt();
            q.add(v);
        }


        move(x, y);

    }


    static class cube {
        int di1;
        int di2;
        int di3;
        int di4;
        int di5;
        int di6;

        public cube(int di1, int di2, int di3, int di4, int di5, int di6) {

            this.di1 = di1;
            this.di2 = di2;
            this.di3 = di3;
            this.di4 = di4;
            this.di5 = di5;
            this.di6 = di6;

        }


    }

}







