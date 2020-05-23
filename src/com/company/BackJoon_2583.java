package com.company;


import java.util.*;

public class BackJoon_2583 {

    static ArrayList<Integer> arr = new ArrayList<>();
    static int m;
    static int n;
    static int count;
    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static void blocks(int [][] m, int lx, int ly, int rx, int ry){

        for(int i = ly; i<ry ; i++){
            for(int j =lx ; j < rx; j++){
                m[i][j] = -1;
            }
        }
    }

    static void bfs(int [][]ma){

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(ma[i][j]!=-1){
                    count++;
                    q.add(i);
                    q.add(j);
                    int hap = 1;
                    ma[i][j] = -1;

                    while (!q.isEmpty()){


                        int x = q.peek();
                        q.poll();
                        int y = q.peek();
                        q.poll();
                        // System.out.println(x+" " + y );
                        for(int k=0; k<4; k++){
                            int nx =  x + dir[k][0];
                            int ny = y + dir[k][1];

                            if(nx>=0 && nx<m &&ny>=0 && ny<n){

                                if (ma[nx][ny]!=-1){
                                    ma[nx][ny] =-1 ;
                                    hap++;
                                    q.add(nx);
                                    q.add(ny);
                                }
                            }

                        }

                    }
                    arr.add(hap);

                }


            }

        }
    }




    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        m =sc.nextInt();
        n = sc.nextInt();
        int k = sc.nextInt();
        int [][] map = new int[m][n];

        for(int i =0; i<k; i++){
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();
            blocks(map,lx,ly,rx,ry);
        }

//        for(int i =0; i<m; i++){
//            System.out.println();
//            for(int j =0; j<n; j++){
//                System.out.print(map[i][j] +" ");
//            }
//        }


        bfs(map);
        Collections.sort(arr);

        System.out.println(count);
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }


    }

}
