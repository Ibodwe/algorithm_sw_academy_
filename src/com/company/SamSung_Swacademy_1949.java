package com.company;

import java.net.SecureCacheResponse;
import java.util.Scanner;
import java.util.Stack;

public class SamSung_Swacademy_1949 {
    static int[][] map;
    static int answer;
    static boolean[][] check;
    static int N;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static Stack<Road> st = new Stack<>();

    static int K;

    static public void dfs(int x,  int y,int k){
        st.add(new Road(x,y,1,1,map[x][y]));
        check[x][y] = true;


        while(!st.isEmpty()){
            int nx = st.peek().x;
            int ny = st.peek().y;

            int count = st.peek().count;
            int currentValue = st.peek().currentValue;
            int number = st.peek().number;
            System.out.println(nx+" " + ny+" " + number );
            boolean flag = false;

            for(int i =0; i<4; i++){
                int nx2 = nx + dir[i][0];
                int ny2 = ny + dir[i][1];

                if(isValid(nx2,ny2)){
                    if(map[nx2][ny2] < currentValue && !check[nx2][ny2]){
                      //  System.out.println(nx2 +" " + ny2);
                        flag = true;
                        number++;
                        check[nx2][ny2]=true;

                        st.add(new Road(nx2,ny2,count,number,map[nx2][ny2]));
                        break;
                    }else if(map[nx2][ny2] - k < currentValue && !check[nx2][ny2] && count==1){
                      //  System.out.println(nx2 +" " + ny2);
                        number++;
                        flag = true;
                        check[nx2][ny2] = true;
                        st.add(new Road(nx2,ny2,0,number,currentValue-k));
                        break;
                    }
                }
            }
            if(!flag){
                answer = Math.max(answer,number);
                //num =1;
                st.pop();
            }

        }
    }
    static public boolean isValid(int a,int b){
        if(a<0 || a>=N || b<0 || b>=N){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();

        for(int t=1; t<=T; t++){
             N = sc.nextInt();
             K = sc.nextInt();
            map = new int[N][N];
            check = new boolean[N][N];
            int [][] map2 = new int[N][N];
            int max = 0;
            answer=0;

            for(int i =0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                    max = Math.max(map[i][j],max);
                }
            }

            for(int i =0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==max){
                        //System.out.println("456");

                        for(int k=1; k<=K; k++){
                            for(int a=0; a<N; a++){
                                for(int b=0; b<N; b++){
                                    check[a][b] = false;
                                }
                            }
                            System.out.println();
                            dfs(i,j,k);

                        }
                    }
                }
            }

            System.out.println("#" + t+ " " + answer);

        }
    }
   static class Road{
        int x;
        int y;
        int count;
        int number;
        int currentValue;
        public Road(int x, int y, int count, int number ,int currentValue ){
            this.x =x;
            this.y = y;
            this.count = count;
            this.number = number;
            this.currentValue = currentValue;
        }
    }
}
