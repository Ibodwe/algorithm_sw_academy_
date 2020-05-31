package com.company;

import java.util.*;

class item implements Comparable<item>{
    int number;
    int hammer;
    int x;
    int y;
    public item(int num, int hammer,int x, int y){
        number = num;
        this.hammer = hammer;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(item o) {
        return hammer - o.hammer;
    }


}

public class BackJoon_1261 {
    // 우선순위 Queue를 통해서 hammer 값이 작은거 부터 꺼내면
    // 최소한의 메모리를 사용해서 구현 할 수 있다.
    static int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int n;
    static int m;
    static item [][] map;
    static boolean[][] vistied;
    static public void dfs(){

        PriorityQueue<item> q = new PriorityQueue<>();
        q.add(map[0][0]);


        while (!q.isEmpty()){

            int x = q.peek().x;
            int y = q.peek().y;
            int currentHam =q.peek().hammer;
            vistied[x][y] = true;
            // System.out.println(x + " " + y + " " + currentHam);
            q.poll();

            if(x==m-1 && y==n-1){
                return;
            }


            for(int i =0; i<4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx >=0 && nx<m && ny >=0 && ny<n && !vistied[nx][ny]){

                    if( currentHam < map[nx][ny].hammer ){

                        //다음 칸의 번호가 0인 경우
                        if(map[nx][ny].number == 1){
                            q.add(new item(map[nx][ny].number,currentHam + 1,nx,ny));
                            vistied[nx][ny] = true;
                        }else{
                            map[nx][ny].hammer = currentHam;
                            q.add(new item(map[nx][ny].number,currentHam ,nx,ny));
                            vistied[nx][ny] =true;
                        }



                    }

                }

            }

            //   System.out.println();

//        for(int i =0; i< m; i++){
//
//            for(int j =0; j<n; j++){
//               System.out.print(map[i][j].hammer+" ");
//            }
//            System.out.println();
//        }

        }


    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String [] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        map = new item[m][n];
        vistied = new boolean[m][n];

        //init
        for(int i =0; i< m; i++){
            String a = sc.nextLine();
            for(int j =0; j<n; j++){
                map[i][j] = new item(a.charAt(j) - 48,9999,i,j);
            }
        }
        map[0][0].hammer =0;

        dfs();

        System.out.println(map[m-1][n-1].hammer);

    }




}
