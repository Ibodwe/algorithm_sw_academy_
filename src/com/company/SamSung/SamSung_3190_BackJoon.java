package com.company.SamSung;


import java.util.*;

public class SamSung_3190_BackJoon {

    static Queue<Integer> snake = new LinkedList<>();
    static Queue<Integer> time = new LinkedList<>();
    static Queue<String> dir = new LinkedList<>();
    static int N;
    static int curTime;
    static boolean [][] checkMap;
    static int [][] map;
    static int [][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void bfs(){
        int x = 0;
        int y = 0;
        checkMap[x][y] = true;
        int d = 0;
        curTime =1;

        while(true){

            int nx = x + direction[d][0];
            int ny = y + direction[d][1];
            System.out.println("x " +nx +" y " + ny +" d " + d +" cur " + curTime);

            if(nx<0|| nx>=N || ny<0 || ny>=N){
                return;
            }else if(checkMap[nx][ny] == true){
                return;
            }else{
                if(map[nx][ny]==1){
                    map[nx][ny]=0;

                }else{
                    int a =   snake.poll();
                    int b =  snake.poll();

                    // System.out.println("poll " + a +" " +b);
                    checkMap[a][b] = false;
                }

                snake.add(nx);
                snake.add(ny);
                x = nx;
                y = ny;
                checkMap[nx][ny] = true;

            }

            if(!time.isEmpty())
                if(curTime==time.peek()){
                    time.poll();
                    String dr = dir.peek();
                    dir.poll();

                    if(dr.equals("D")){
                        System.out.println("D");
                        d++;
                    }else{
                        d--;
                    }
                    if(d < 0){
                        d = 3;
                    }else if(d > 3){
                        d = 0;
                    }
                }

            for(int i =0; i<N; i++ ){
                for(int j =0; j<N; j++){
                    System.out.print(checkMap[i][j]+" ");
                }
                System.out.println();
            }
            curTime++;

        }

    }







    public static void main(String[] args) {

        //뱀의 몸 --> Queue
        //뱀의 방향 --> Queue

        Scanner sc=  new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int [N][N];
        checkMap = new boolean[N][N];
        int K = Integer.parseInt(sc.nextLine());



        for(int i =0; i<K; i++){
            String[] a = sc.nextLine().split(" ");
            int x = Integer.parseInt(a[0])-1;
            int y = Integer.parseInt(a[1])-1;
            map[x][y] = 1;
        }

        int L = Integer.parseInt(sc.nextLine());

        for(int i=0; i<L; i++){
            String[] a = sc.nextLine().split(" ");
            int x = Integer.parseInt(a[0]);
            String c = a[1];
            time.add(x);
            dir.add(c);
        }

        snake.add(0);
        snake.add(0);

        bfs();

        System.out.println(curTime);

    }


}







