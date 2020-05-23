package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Kakao2 {


    public static void main(String[] args) {

        int [][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int [][] valueMap = new int [board.length][board.length];
        boolean [][]visited = new boolean[board.length][board.length];
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int answer = 99999999;
        Queue<Integer> q = new LinkedList<>();

        if(board[1][0]!=1){
        q.add(1);
        q.add(0);
        q.add(3);
        valueMap[0][1] = 200;
        valueMap[1][0] = 200;

        while(!q.isEmpty()){

            int x = q.peek();
            q.poll();
            int y = q.peek();
            q.poll();
            int direction =q.peek();
            q.poll();
            visited[1][0] = true;
            visited[0][0] = true;
            visited[x][y] = true;
            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx >= 0 && nx < board.length && ny >=0 && ny< board[0].length) {
                    if(board[nx][ny]!=1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(nx);
                        q.add(ny);
                        q.add(i);
                        if(direction!=i){
                            valueMap[nx][ny] = valueMap[x][y] +500;
                        }else{
                            valueMap[nx][ny] = valueMap[x][y] +100;
                        }
                    }
                }
            }


        }

         answer = Math.min(answer,valueMap[board.length-1][board.length-1]);
        }

        for(int i =0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                valueMap[i][j] =0;
                visited[i][j] = false;
            }
        }






        if(board[0][0]!=1){
            q.add(0);
            q.add(1);
            q.add(0);
            valueMap[0][1] = 200;
            valueMap[1][0] = 200;

            while(!q.isEmpty()){

                int x = q.peek();
                q.poll();
                int y = q.peek();
                q.poll();
                int direction =q.peek();
                q.poll();
                visited[0][1] = true;
                visited[0][0] = true;
                visited[1][0] = true;
                for(int i =0; i<4; i++){
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if(nx >= 0 && nx < board.length && ny >=0 && ny< board[0].length) {
                        if(board[nx][ny]!=1 && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(nx);
                            q.add(ny);
                            q.add(i);
                            if(direction!=i){
                                valueMap[nx][ny] = valueMap[x][y] +500;
                            }else{
                                valueMap[nx][ny] = valueMap[x][y] +100;
                            }
                        }
                    }
                }


            }

        }

        answer = Math.min(answer,valueMap[board.length-1][board.length-1]);


    }


}
