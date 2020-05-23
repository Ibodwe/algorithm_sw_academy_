

package com.company;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BackJoon_7576{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int [][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int [][] value = new int[n][m];

        Queue<Integer> qu = new LinkedList<>();


        for(int i =0; i< n; i++){
            for(int j =0; j< m; j++){
                map[i][j]= sc.nextInt();
                if(map[i][j]==1){
                    qu.add(i);
                    qu.add(j);
                }
            }
        }

        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};


        int answer= 0;

        while (!qu.isEmpty()){

            int x = qu.peek();
            qu.poll();
            int y = qu.peek();
            qu.poll();


            //     System.out.println(x+" " + y);
            visited[x][y] = true;

            for(int i =0; i<4; i++){

                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx>= 0 && nx< n && ny>=0 && ny < m){
                    if(map[nx][ny]==0 && !visited[nx][ny]){
                        qu.add(nx);
                        qu.add(ny);
                        map[nx][ny] =1;
                        value[nx][ny] = value[x][y]+1;
                    }

                }
            }

        }

        boolean flag = false;
        for(int i =0; i< n; i++){
            for(int j =0; j< m; j++){

                if(map[i][j]==0){
                    flag = true;
                }else{
                    answer = Math.max(answer,value[i][j]);
                }
            }
        }


        if(flag)
            System.out.println(-1);
        else
            System.out.println(answer);

    }

}