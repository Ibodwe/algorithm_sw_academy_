package com.company.BackJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BackJoon_2589 {

    static int answer = 0;

    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] valueMap;
    static char[][] map;
    static int h;
    static int w;

    static void dfs( int a, int b){
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        q.add(b);
        valueMap[a][b]=0;

        while(!q.isEmpty()){
            int x = q.peek();
            q.poll();
            int y = q.peek();
            q.poll();

            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(isInside(nx,ny) && map[nx][ny]=='L'){
                    if((valueMap[nx][ny]==999999) || (valueMap[x][y]+1 < valueMap[nx][ny])){
                        valueMap[nx][ny] = valueMap[x][y]+1;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }
        }

        for(int i =0; i<h; i++){
            for(int j =0; j<w; j++){

                if(map[i][j]=='L' && valueMap[i][j]!=999999){
                    answer = Math.max(answer, valueMap[i][j]);
                }

                valueMap[i][j] = 999999;
            }
        }

    }

    static boolean isInside(int a, int b){

        if(a < 0 || a >= h || b<0 || b>=w){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String [] temp = sc.nextLine().split(" ");

        h = Integer.parseInt(temp[0]);
        w = Integer.parseInt(temp[1]);

        map = new char [h][w];

        valueMap = new int[h][w];

        for(int i =0; i<h; i++){
            for(int j=0; j<w; j++){
                valueMap[i][j] = 999999;
            }
        }

        for(int i =0; i<h; i++){
            String tem = sc.nextLine();
            for(int j=0; j<w; j++){
                map[i][j] = tem.charAt(j);
            }
        }

        for(int i =0; i<h; i++){
            for(int j =0; j<w; j++){
                if(map[i][j]=='L'){
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);


    }

}

