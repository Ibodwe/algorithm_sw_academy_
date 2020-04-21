package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SamSung_Swacademy_5650 {

    // 0 ->위, 1-> 아래, 2-> 오, 3-> 왼
    static int[][] direct = {{-1,0},{1,0},{0,1},{0,-1}};
    static ArrayList<warmHole> wm = new ArrayList<>();
    static int answer = 0;
    static int N;
    static int blackX,blackY;
    static   int map[][];
    //부딪히는 모양이
    public static void search(int x, int y, int dir) {
        int count = 0;

        int curDir = dir;
        int nx =x ;
        int ny =y ;
        boolean a = true;
        while (a){

            nx = nx + direct[curDir][0];
            ny = ny + direct[curDir][1];

            //  System.out.println("nx " + nx + " ny " + ny + " curDir " +curDir);

            if(nx == x && ny ==y){
                a= false;
                answer = Math.max(answer,count);
                return;
            }

            if(nx<0){
                if(x-1 == nx){
                    return;
                }
                //위로 올라가는 경우
                curDir = 1;
                nx =0;
                count++;
            }else if(nx>=N){
                if(x+1 == nx){
                    return;
                }
                curDir = 0;
                nx = N-1;
                count++;
            }else if(ny<0){
                if(y-1 == ny){
                    return;
                }
                curDir = 2;
                ny = 0;
                count++;
            }else if(ny>=N){
                if(y+1 == ny){
                    return;
                }
                curDir=3;
                ny = N-1;
                count++;
            }


            int value = map[nx][ny];

            switch (value){
                case -1:
                    a = false;
                    answer = Math.max(answer,count);
                    return;
                // 0 ->위, 1-> 아래, 2-> 오, 3-> 왼
                case 1:
                    count++;
                    if(curDir==0){
                        curDir=1;
                    }else if(curDir == 1){
                        curDir=2;
                    }else if(curDir==2){
                        curDir= 3;
                    }else{
                        curDir=0;
                    }
                    break;

                case 2:
                    count++;
                    if(curDir==0){
                        curDir=2;
                    }else if(curDir == 1){
                        curDir=0;
                    }else if(curDir==2){
                        curDir= 3;
                    }else{
                        curDir=1;
                    }
                    break;
                // 0 ->위, 1-> 아래, 2-> 오, 3-> 왼
                case 3:
                    count++;
                    if(curDir==0){
                        curDir=3;
                    }else if(curDir == 1){
                        curDir=0;
                    }else if(curDir==2){
                        curDir= 1;
                    }else{
                        curDir=2;
                    }
                    break;

                case 4:
                    count++;
                    if(curDir==0){
                        curDir=1;
                    }else if(curDir == 1){
                        curDir=3;
                    }else if(curDir==2){
                        curDir= 0;
                    }else{
                        curDir=2;
                    }
                    break;

                case 5:
                    count++;
                    if(curDir==0){
                        curDir=1;
                    }else if(curDir == 1){
                        curDir=0;
                    }else if(curDir==2){
                        curDir= 3;
                    }else{
                        curDir=2;
                    }
                    break;
                case 6:
                    if(nx == wm.get(0).x && ny == wm.get(0).y){
                        nx = wm.get(1).x;
                        ny = wm.get(1).y;
                    }else{
                        nx = wm.get(0).x;
                        ny = wm.get(0).y;
                    }
                    break;
                case 7:
                    if(nx == wm.get(2).x && ny == wm.get(2).y){
                        nx = wm.get(3).x;
                        ny = wm.get(3).y;
                    }else{
                        nx = wm.get(2).x;
                        ny = wm.get(2).y;
                    }
                    break;
                case 8:
                    if(nx == wm.get(4).x && ny == wm.get(4).y){
                        nx = wm.get(5).x;
                        ny = wm.get(5).y;
                    }else{
                        nx = wm.get(4).x;
                        ny = wm.get(4).y;
                    }
                    break;
                case 9:
                    if(nx == wm.get(6).x && ny == wm.get(6).y){
                        nx = wm.get(7).x;
                        ny = wm.get(7).y;
                    }else{
                        nx = wm.get(6).x;
                        ny = wm.get(6).y;
                    }
                    break;
                case 10:
                    if(nx == wm.get(8).x && ny == wm.get(8).y){
                        nx = wm.get(9).x;
                        ny = wm.get(9).y;
                    }else{
                        nx = wm.get(8).x;
                        ny = wm.get(8).y;
                    }
                    break;
            }
        }

    }




    public static void main(String[] args) {
        //핀볼의 최대값은 --> 위 아래 왼 오 의 한번만 비교하면됨!! 어차피 처음 시작 후는 자율

        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for(int c =1; c<=T; c++) {
            N = Integer.parseInt(sc.nextLine());
            answer=0;
            map = new int[N][N];

            for(int i=0; i< N; i++){
                String[] vv = sc.nextLine().split(" ");
                for(int j =0; j<N; j++){
                    int va = Integer.parseInt(vv[j]);
                    map[i][j] = va;

                    if(va==-1){
                        blackX = i;
                        blackY = j;
                    }
                    if(va > 5){
                        wm.add(new warmHole(i,j,va));
                    }
                }
            }

            Collections.sort(wm);

            for(int i=0; i< N; i++){
                for(int j =0; j<N; j++){
                    if(map[i][j]==0){
                        for(int k=0; k<4; k++){
                            //   System.out.println("strat!!!!!!!!!!! " + i +" " + j + " " + k);
                            search(i,j,k);
                            //    System.out.println("answer " + answer);
                        }
                    }
                }
            }

            System.out.println("#"+c +" " +answer);
            wm.clear();
        }


    }

    static class warmHole implements Comparable<warmHole>{
        int x ;
        int y ;
        int index;
        public warmHole(int x, int y ,int index){
            this.x = x ;
            this.y= y;
            this.index= index;
        }

        @Override
        public int compareTo(warmHole o) {
            return this.index - o.index;
        }
    }
}


