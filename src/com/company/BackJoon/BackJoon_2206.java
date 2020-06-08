package com.company.BackJoon;

import java.util.*;

public class BackJoon_2206 {


    static int[][] map;
    static int[][] valueMap;
    static int[][] countMap;

    static boolean[][] checkMap;
    static int m;
    static int n;
    static Queue<Integer> q;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void bfs() {
        while (!q.isEmpty()){
            int x = q.peek();
            q.poll();
            int y =q.peek();
            q.poll();

            if(x==m-1 && y==n-1){
                return;
            }
            int drill = countMap[x][y];

            for(int i =0; i<4; i++){
                int nx = dir[i][0] + x;
                int ny = dir[i][1] + y;

                if(nx>=0 && nx<m && ny>=0 && ny < n ){

                    //countMap을 max값으로 초기화 하여 방문 여부를 판단..!
                    //이렇게 짜도 되는건 질문에서 nx ny의 값을 물어 봤기 때문
                    //중복으로 방문하지 않는다면 2차원 map에서는 무조건 최단거리..!
                    //벽을 한개만 뚫고 중복 없이 갈수 있는지 없는 지를 묻는 문제..!

                    if(drill >= countMap[nx][ny]){
                        continue;
                    }

                    if(map[nx][ny]==0){
                        q.add(nx);
                        q.add(ny);
                        valueMap[nx][ny] = valueMap[x][y]+1;
                        countMap[nx][ny] = drill;

                    }else{
                        //어차피 1이 넘으면 추가하면 안되기 때문에..!
                        if(drill==0){
                            q.add(nx);
                            q.add(ny);
                            countMap[nx][ny] = drill+1;
                            valueMap[nx][ny] = valueMap[x][y]+1;
                        }

                    }

                }

            }

        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] t = sc.nextLine().split(" ");
        m = Integer.parseInt(t[0]);
        n = Integer.parseInt(t[1]);
        q = new LinkedList<>();
        map = new int[m][n];
        valueMap = new int[m][n];
        checkMap = new boolean[m][n];
        countMap = new int[m][n];



        for (int i = 0; i < m; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < n; j++) {
                int num = temp.charAt(j);
                map[i][j] = num -48;
                valueMap[i][j] =999999;
                countMap[i][j] =999999;
            }
        }



        valueMap[0][0] =1;
        checkMap[0][0] = true;
        countMap[0][0] = 0;

        q.add(0);
        q.add(0);

        bfs();

        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(valueMap[i][j] +" ");
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(countMap[i][j] +" ");
            }
        }

        if(valueMap[m-1][n-1]==999999){
            System.out.println(-1);
        }else{
            System.out.println(valueMap[m-1][n-1]) ;
        }

    }



}
