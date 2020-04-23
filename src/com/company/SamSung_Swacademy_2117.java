package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class SamSung_Swacademy_2117 {


    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int max = 0;
    static int count =0;
    static int N;
    static int M;
    static  int [][]map;

    static ArrayList<Dot> q = new ArrayList<>();
    static int[][] qmap;
    static int cal (int k){
        return k*k + (k-1)*(k-1);
    }

    static void  bfs(int x, int y, int k){

        int innercount = 0;
        if(k==1){
            if(map[x][y]==1){
                innercount++;
            }
        }else{
            //기준점을 정해야 하는데 기준점은
            int ax = x - q.get(0).x;
            int ay = y- q.get(0).y;

            for(int i =0; i<q.size();i++){
                int nx = q.get(i).x +ax;
                int ny = q.get(i).y +ay;

                if(isValid(nx,ny)) {
                    if (map[nx][ny] == 1) {
                        //          System.out.println("nx " + nx + " ny " + ny);
                        innercount++;
                    }
                }
            }
            //   System.out.println("innerCount " + innercount +" index " + k);
        }

        if(innercount * M >= cal(k)){

            count = Math.max(innercount,count);
        }

    }



    static void makeQ(){
        int length = q.size();
        for(int i = 0; i < length; i++){
            int nx = q.get(i).x;
            int ny = q.get(i).y;
            for(int j=0; j<4; j++){
                int nx2 = nx+dir[j][0];
                int ny2 = ny +dir[j][1];

                if(nx2>=0 && ny2>=0 && nx2< 2*N+1 && ny2<2*N+1){
                    if(qmap[nx2][ny2]==0){
                        qmap[nx2][ny2]=1;
                        q.add(new Dot(nx2,ny2));
                    }
                }
            }

        }
//        System.out.println("qStart");
//        for(int i =0; i<q.size(); i++){
//            System.out.println(q.get(i).x+" " + q.get(i).y);
//        }
//        System.out.println("qSize "+q.size());

    }

    public static boolean isValid(int x, int y){
        if( x < 0 || x >=N || y < 0 || y>=N){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        //--> K==1로  얻을 수 있는 최대 수익 비용 보다 크다면 k++
        //--> K==2

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int answer = 0;
        for(int n = 1; n<=T; n++){
            N = sc.nextInt();
            //1개집 비용
            answer = 0;
            M = sc.nextInt();
            count = 0;
            map = new int [N+1][N+1];
            int oneNum = 0;
            qmap = new int[2*N+1][2*N+1];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                    if(map[i][j]==1){
                        oneNum++;
                    }
                }
            }

            boolean check = true;
            int index = 1;
            while(check){

                if(index > 1){
                    makeQ();

                }else{
                    qmap[N][N] = 1;
                    q.add(new Dot(N,N));
                }

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        bfs(i,j,index);
                    }
                }


                if(oneNum * M <= cal(index)){
                    //System.out.println("oneNum " + oneNum);
                    check=false;
                }

                index++;

            }

            System.out.println("#"+n +" " + count);
            q.clear();

        }

    }

    static public class Dot{
        int x;
        int y;
        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }

    }


}
