package com.company.BackJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//dfs 와 bfs의 결정적 차이는 수행할 때 사용 되는 최대 메모리!!!!!!!!!!!!


public class BackJoon_2146   {


    static int answer = 99999999;
    static int [][] valueMap;
    static int [][] map;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    // static boolean[][] visited;
    static int t;


    static void bfs(int i , int j , int value, int count ){



        for(int k=0; k<4; k++){
            int nx = i + dir[k][0];
            int ny = j + dir[k][1];

            if(nx>=0 && ny>=0 && nx <t && ny<t ){
                if(map[nx][ny] < value) {
                    if(count < answer){
                        answer = count;
                    }
                }

                if(map[nx][ny] == 0 && valueMap[nx][ny] > valueMap[i][j]+1){
                    valueMap[nx][ny] = count+1;
                    bfs(nx,ny,value,count+1);
                }

            }
        }


    }


    static public void initMap(){
        int count = -1;

        for(int i =0; i<t; i++){
            for(int j =0; j<t; j++){
                if(map[i][j]==1){
                    initbfs(i,j,count);
                    count--;
                }
            }
        }

    }

    static void initbfs(int i , int j,int count ){


        map[i][j] = count;

        for(int k=0; k<4; k++){
            int nx = i+dir[k][0];
            int ny = j + dir[k][1];

            if(nx>=0 && ny>=0 && nx <t && ny<t ){
                if(map[nx][ny]==1){
                    initbfs(nx,ny,count);
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        t =Integer.parseInt(st.nextToken());

        map = new int [t][t];
        valueMap = new int [t][t];
        //visited = new boolean[t][t];
        for(int i =0; i<t; i++){
            st = new StringTokenizer(bf.readLine()," ");
            for(int j =0; j<t; j++){
                int k  = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if(k ==0){
                    valueMap[i][j] = 99999;
                }
            }
        }
        initMap();

        for(int i =0; i<t; i++){
            for(int j =0 ; j<t; j++){
                if(map[i][j]!=0){
                    bfs(i,j,map[i][j],0);
                }
            }
        }


        for(int i =0; i<t; i++){
            System.out.println();
            for(int j =0 ; j<t; j++){
                System.out.print(valueMap[i][j] +" ");
            }
        }
        System.out.println(answer);



    }
}

