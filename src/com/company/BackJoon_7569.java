package com.company;

import java.util.*;

public class BackJoon_7569 {

    static Queue<Integer> q;
    static int [][][] map;
    static int m;
    static int n ;
    static  int h ;
    static int answer;
    static int[][] dir ={{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
    static boolean [][][] isVisited;

    static boolean isInside(int a, int b ,int c) {

        if(a>=0 && a < h && b>=0 && b < m && c>=0 && c<n ){
            return true;
        }
        //    System.out.println(h+" " + m +" " + n);
        //   System.out.println(a+" " +b+ " " +c );

        return false;
    }

    static boolean check(){

        for(int i=0; i<h; i++){
            for(int j =0; j<m;j++){
                for(int k =0; k<n; k++){
                    if(map[i][j][k]==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    static boolean bfs(){
        int si = q.size();
        boolean isFinished = false;
        //딱 q size 만큼만 팝 하고

        if(q.size()==0){
            return  true;
        }

        for(int i =0; i<si/3; i++){
            int a = q.peek();
            q.poll();
            int b = q.peek();
            q.poll();
            int c = q.peek();
            q.poll();

            for(int j =0; j<6; j++){
                int nx = a + dir[j][0];
                int ny = b + dir[j][1];
                int nz = c + dir[j][2];



                if(isInside(nx,ny,nz) && map[nx][ny][nz]==0){
                    isVisited[nx][ny][nz] = true;

                    q.add(nx);
                    q.add(ny);
                    q.add(nz);
                    map[nx][ny][nz] =1;
                    isFinished = true;
                }
            }

        }
        if(isFinished){
            answer++;
        }


        return isFinished;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        map = new int[h][m][n];
        isVisited = new boolean[h][m][n];

        q = new LinkedList<>();
        answer = 0;
        for(int i=0; i<h; i++){
            for(int j =0; j<m;j++){
                for(int k =0; k<n; k++){
                    int num = sc.nextInt();
                    map[i][j][k] = num;

                    if(num == 1 ){
                        q.add(i);
                        q.add(j);
                        q.add(k);
                        isVisited[i][j][k] = true;
                    }
                }
            }
        }

        while (true){
            boolean a = bfs();
            if(a){

            }else{
                break;
            }
        }

        boolean an = check();



        if(an){
            System.out.println(answer);

        }else {
            System.out.println(-1);
        }



    }

}
