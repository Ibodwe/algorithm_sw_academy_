package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SamSung_16234_BaekJoon {

    static int n;
    static int l;
    static int r;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int [][] map;
    static boolean [][] boolMap;
    static int answer =0;

    static public void check(){
        //boolMap초기화 필요
        boolean [][] visited = new boolean[n][n];

        boolean a = true;

        for(int i =0; i<map.length; i++){
            for (int j =0; j<map.length; j++){
                boolMap[i][j] = false;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();

        for(int i =0; i<map.length; i++){
            for(int j =0; j<map.length;j++){

                if(!boolMap[i][j]){
                    boolMap[i][j] = true;
                    queue.add(i);
                    queue.add(j);
                    qu2.add(i);
                    qu2.add(j);
                    int size = 1;
                    int number = 0;
                    number+= map[i][j];

                    while(!queue.isEmpty()){
                        int startX = queue.peek();
                        queue.poll();
                        int startY = queue.peek();
                        queue.poll();

                        for(int k=0; k<4; k++){
                            int x = startX + dir[k][0];
                            int y = startY + dir[k][1];

                            if(isValid(x,y) ){
                                boolean d = cal(startX,startY,x,y);

                                if(d && (boolMap[x][y]==false)){

                                    queue.add(x);
                                    queue.add(y);
                                    qu2.add(x);
                                    qu2.add(y);
                                    size++;
                                    number+= map[x][y];

                                    boolMap[x][y] = true;
                                    a = false;
                                }
                            }
                        }

                    }
                    int value = number/size;

                    while (!qu2.isEmpty()){
                        int x =qu2.peek();
                        qu2.poll();
                        int y = qu2.peek();

                        qu2.poll();
                        map[x][y] = value;
                    }


                }

            }
        }


        if(!a){
            answer++;
            check();
        }else{
            return;
        }

    }






    static public boolean cal(int x1, int y1, int x2, int y2){
        int v1 = map[x1][y1];
        int v2 = map[x2][y2];
        int result =Math.abs(v1-v2);

        if( result >= l && result <=r){
            return true;
        }
        return false;
    }


    static public boolean isValid(int a, int b ){
        if(a < 0 || a >= n || b < 0 ||b >= n){
            return  false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //현재방향
        //후진

        n =sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        map = new int [n][n];

        boolMap = new boolean[n][n];

        for(int i =0; i<n; i++){
            for(int j =0; j<n ;j++){
                map[i][j] = sc.nextInt();
            }
        }

        check();

        System.out.println(answer);

    }

}
