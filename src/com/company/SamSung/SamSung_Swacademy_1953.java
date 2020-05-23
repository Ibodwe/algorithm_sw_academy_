package com.company.SamSung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SamSung_Swacademy_1953 {

    //파이프의 연결 가능은 상 하 좌 우
    static boolean[][] pipe = {{false,false,false,false},{true,true,true,true},{true,true,false,false},
            {false,false,true,true},{false,true,true,false},{true,false,true,false},{true,false,false,true},{false,true,false,true}};

    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N;
    static int M;
    static int[][] map;
    static int[][] numMap;

    static public void bfs(int x,int y){
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        q.add(y);
        numMap[x][y] =1;

        while(!q.isEmpty()){
            int nx =q.peek();
            q.poll();
            int ny =q.peek();
            q.poll();

            //파이프의 번호
            int value = map[nx][ny];

            for(int i =0; i<4; i++){
                if(pipe[value][i]){
                    //기존의 있는 파이프에서 이동 할 수있음
                    int nx2 = nx;
                    int ny2 = ny;
                    int k = i ;
                    if(value>3){
                        switch (k){
                            case 0:
                                k=1;
                                break;
                            case 1:
                                k=0;
                                break;
                            case 2:
                                k=3;
                                break;
                            case 3:
                                k=2;
                                break;
                        }
                    }
                        nx2 = nx+dir[k][0];
                        ny2 = ny+dir[k][1];

                    if(isValid(nx2,ny2)){
                       // System.out.println(nx2+" " + ny2+" ");
                        int value2 = map[nx2][ny2];
                      //  System.out.println("value2 " + value2 +" i " + i);
                        //값이 1만큼
                        if(pipe[value2][k] && numMap[nx2][ny2]==0){
                            q.add(nx2);
                            q.add(ny2);
                            numMap[nx2][ny2] = numMap[nx][ny]+1;
                        }

                    }

                }

            }

        }

    }

    static public boolean isValid(int a,int b){
        if(a<0 || a>=N || b<0 || b>=M){
            return false;
        }
        return true;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
             N = sc.nextInt();
             M = sc.nextInt();
            int R = sc.nextInt();
            int C = sc.nextInt();
            int L = sc.nextInt();
            int answer = 0 ;
            map = new int[N][M];
            numMap = new int [N][M];
            for(int i=0; i<N; i++){
                for(int j =0; j<M; j++){
                    map[i][j] = sc.nextInt();
                    numMap[i][j]=0;
                }
            }

            bfs(R,C);

            for(int i=0; i<N; i++){
                for(int j =0; j<M; j++){
                //    System.out.print(numMap[i][j]+" ");
                   if(numMap[i][j]<=L && numMap[i][j]!=0){
                       answer++;
                   }

                }
            //    System.out.println();
            }

            System.out.println("#"+t+" " + answer);
        }

    }
}
