package com.company;

import java.util.*;

public class SamSung_16236_BackJoob {

    static int[][] map ;
    static int sharkSize = 2;
    static int sharkx = 0;
    static int sharky = 0;
    static int time = 0 ;
    static int sharkStack=0;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static ArrayList<Feed> q = new ArrayList<>();

    static Queue<Integer> q2 = new LinkedList<Integer>();

    static  public void shark(){
        //좌표의 절대 값이 거리..!
        q2.add(sharkx);
        q2.add(sharky);
        boolean [][] sharkMap = new boolean[map.length][map.length];
        int [][] valueMap = new int[map.length][map.length];


        sharkMap[sharkx][sharky] = true;
        int minX = -1;
        int minY = -1;
        int minLength = 99999;
        int distance = 0;
        int count = 0;
        while(!q2.isEmpty()){

            int x = q2.peek();
            q2.poll();
            int y =q2.peek();
            q2.poll();



            for(int i =0; i<4; i++){

                int x2 = x + dir[i][0];
                int y2 = y + dir[i][1];

                if(isValide(x2,y2) && map[x2][y2] <= sharkSize && sharkMap[x2][y2]==false) {
                    sharkMap[x2][y2] = true;
                    valueMap[x2][y2] = valueMap[x][y]+1;
                        System.out.println(x2+" " + y2);
                    if(map[x2][y2] < sharkSize && map[x2][y2] >0){

                         //distance = callength(x2,y2,sharkx,sharky);
                         distance = valueMap[x][y]+1;

                        if(distance <= minLength){

                            if(distance == minLength){
                                if(x2 <= minX){

                                    if(x2==minX){
                                        if(y2 < minY){

                                            minLength = distance;
                                            minX = x2;
                                            minY = y2;

                                        }else{
                                            continue;
                                        }

                                    }else{
                                        minLength = distance;
                                        minX = x2;
                                        minY = y2;
                                    }
                                }else{
                                    continue;
                                }

                            }else{
                                minLength = distance;
                                minX = x2;
                                minY = y2;
                            }

                        }
                    }
                    q2.add(x2);
                    q2.add(y2);
                }
            }
        }

        if(minX!=-1 && minY!=-1){
        //가능한 최저값을 찾아냈기에
        map[minX][minY] = 9;
        map[sharkx][sharky] = 0 ;
        sharkx = minX;
        sharky = minY;
        sharkStack++;

        if(sharkStack==sharkSize){
            sharkStack=0;
            sharkSize++;
        }

        time+= minLength;

        System.out.println();
        System.out.println("sharkSize " + sharkSize);
        for(int i =0; i<map.length;i++){
            for (int j =0; j<map.length;j++){
                System.out.print(valueMap[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("time " + time);

            for(int i =0; i<map.length;i++){
                for (int j =0; j<map.length;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        shark();
        }else{
           // System.out.println(0);
            return;
        }
    }

    static boolean isValide(int a, int b){

        if(a<0 || a >= map.length || b<0 || b>=map.length){
            return false;
        }
        return true;
    }



    static  public int callength(int x1, int y1, int x2, int y2){
        int a = Math.abs(x2-x1) ;
        int b =Math.abs(y2-y1);
        return a+b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

         map = new int[N][N];

        for(int i =0; i< N; i++){
            for(int j =0; j<N;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==9){
                    sharkx=i;
                    sharky=j;
                }
            }
        }

        shark();
        System.out.println(time);
    }

    //class 의 값을 비교 하고 싶을 떄는 Comparable
  static class Feed implements Comparable<Feed> {
        int x;
        int y;
        int length;
        Feed(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }

      @Override
      public int compareTo(Feed o) {
          return length - o.length;
      }
  }
}
