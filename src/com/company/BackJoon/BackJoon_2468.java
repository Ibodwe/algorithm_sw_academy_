

package com.company.BackJoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BackJoon_2468{


    static int [][] map ;
    static boolean[][] check;
    static int n ;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static public int bfs(int num){

        check = new boolean[n][n];
//       for(int i =0; i<n; i++){
//           for(int j =0; j<n; j++) {
//                check[i][j] = false;
//           }
//
//           }
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        //   System.out.println();
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(!check[i][j] && map[i][j] > num){
                    //i,j 로 시작
                    answer++;
                    // System.out.println(i+" " + j );
                    q.add(i);
                    q.add(j);
                    check[i][j] = true;
                    while (!q.isEmpty()){

                        int nx = q.peek();
                        q.poll();
                        int ny = q.peek();
                        q.poll();

                        for(int k=0; k<4; k++){
                            int nx2 = nx + dir[k][0];
                            int ny2 = ny + dir[k][1];

                            if(nx2 >=0 && nx2<n && ny2>=0 && ny2<n){
                                if(!check[nx2][ny2] && map[nx2][ny2]>num){
                                    q.add(nx2);
                                    q.add(ny2);
                                    //    System.out.println(nx2+" 123123 " +ny2);
                                    check[nx2][ny2] = true;
                                }

                            }
                        }
                    }

                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        n =sc.nextInt();

        map = new int [n][n];
        //check = new boolean[n][n];

        int an = 0;
        int max = 0;
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                int k = sc.nextInt();
                //      System.out.println(k);
                map[i][j] = k ;
                max = Math.max(k,max);

            }
        }

        //    System.out.println(max + " max ");
        for(int i =0; i < max; i++){
            int a = bfs(i);
            an = Math.max(an,a);
        }

        System.out.println(an);







    }
}