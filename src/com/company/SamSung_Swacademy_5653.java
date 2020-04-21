package com.company;


import java.util.ArrayList;
import java.util.Scanner;


public class SamSung_Swacademy_5653 {

    static int[][] map;

    static int[][] checkMap;

    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static int K, currentTime,answer ;

    static ArrayList<moth> m = new ArrayList<moth>();

    static public void bfs(int x, int y ){

        int nX = x;
        int nY = y;

        //한번 번식하고나면 추가로 번식불가!
        // System.out.println(currentTime);
        //   System.out.println("x " +nX +" y " + nY);

        //죽은 친구들의 수를 어떻게 판별 해 줄지!!

        //끝났을 때 currenttime - value 값이 >0 크면 살아있는거네!!

        for(int i = 0; i<4; i++){
            int value = map[nX][nY];
            if (map[nX+ dir[i][0]][nY + dir[i][1]]==0){
                moth a = new moth(nX+ dir[i][0],nY + dir[i][1] ,value);
                if(!m.contains(a)){
                    m.add(a);
                }
            }
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i =1; i<=T; i++){
            currentTime=1;
            int N = sc.nextInt();
            int M = sc.nextInt();
            K = sc.nextInt();

            checkMap = new int[400][400];
            map =  new int [400][400];

            answer=0;
            //초기
            for(int j= 200; j<200+N; j++ ){
                for(int n =200; n<200+M; n++ ){
                    map[j][n] = sc.nextInt();
                    checkMap[j][n]= map[j][n] ;
                }
            }

            //1은 비활성 2은 활성 -1 은 죽음..!
            while(currentTime < K){
                //번식스
                for(int j =0; j<400; j++){
                    for(int n =0; n<400; n++){
                        if(checkMap[j][n]==currentTime){
                            bfs(j,n);
                        }
                    }
                }

                //여기에 값 정리
                for(int k=0; k< m.size(); k++){
                    int x = m.get(k).x;
                    int y = m.get(k).y;
                    int value = m.get(k).value;

                    if(map[x][y]==0){
                        map[x][y] = value;
                        checkMap[x][y] = currentTime+value+1;
                    }else{
                        int max = Math.max(value, map[x][y]);
                        map[x][y] = max;
                        checkMap[x][y] = currentTime+max+1;
                    }

                }
                m.clear();

//                for(int j =170; j<200; j++){
//                    for(int n =170; n<200; n++){
//                        System.out.print(map[j][n]);
//                    }
//                    System.out.println();
//                }

                currentTime++;
            }

//            for(int j =170; j<200; j++){
//                for(int n =170; n<200; n++){
//                    System.out.print(map[j][n]);
//                }
//                System.out.println();
//            }

            for(int j =0; j<400; j++){
                for(int n =0; n<400; n++){
                    if(checkMap[j][n] + map[j][n] > currentTime){
                        answer++;
                    }

                }
            }

            System.out.println("#"+i+" " + answer);

        }

    }

    static class moth{
        int x;
        int y;
        int value;

        public moth(int x, int y , int value){
            this.x =x ;
            this.y =y;
            this.value =  value;
        }

    }
}

