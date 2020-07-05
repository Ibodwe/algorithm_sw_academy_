package com.company.BackJoon;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BackJoon_2573 {

    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static  boolean [][]chMap;
    static Queue<Integer> q2 = new LinkedList<>();

    static public void check(int [][] map, int a ,int b){

        chMap[a][b] = true;

        for(int i =0; i<4; i++){
            int nx = a+dir[i][0];
            int ny = b+dir[i][1];

            if(map[nx][ny]<=0 && !chMap[nx][ny]){
                map[a][b]--;
            }

            if(map[nx][ny] > 0 && !chMap[nx][ny]){
                check(map,nx,ny);
            }

        }



        //init checkmap


    }


    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int   m = Integer.parseInt(st.nextToken());

        int [][] map = new int [n][m];
        chMap = new boolean [n][m];
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer =0;
        int count = 0;
        while (count < 2){
            count =0;

            for(int i =1; i<n; i++){
                for(int j =1; j<m; j++){
                    if(!chMap[i][j] && map[i][j]>0){
                        check(map,i,j);
                        count++;
                    }
                    chMap[i][j] = false;
                }
            }

            if(count==0){
                break;
            }

            answer++;
        }

        if(count==0){
            System.out.println(0);
        }else{
            System.out.println(answer-1);

        }



    }


}
