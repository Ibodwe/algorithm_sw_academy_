    package com.company;

    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;

    public class BackJoon_11724 {

      static   char [][]map;
      static   boolean[][] checkMap;
      static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
      static int n;
      static int answer = 0;
      static public void normal(int a,int b){
            Queue<Integer> q = new LinkedList<>();
            char st = map[a][b];
            q.add(a);
            q.add(b);
            answer++;

            while(!q.isEmpty()){
                int x = q.peek();
                q.poll();
                int y =q.peek();
                q.poll();

                checkMap[x][y] = true;

                for(int i =0; i<4; i++){
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if(nx<n && nx>=0 && ny<n && ny>=0 && !checkMap[nx][ny]){
                        if(map[nx][ny]==st){
                            q.add(nx);
                            q.add(ny);
                            checkMap[nx][ny] =true;
                        }
                    }
                }
            }

        }


        static public void redgreen(int a,int b){


            Queue<Integer> q = new LinkedList<>();
            char st = map[a][b];
            q.add(a);
            q.add(b);
            answer++;


          //  System.out.println("st " + st);

            while(!q.isEmpty()){
                int x = q.peek();
                q.poll();
                int y =q.peek();
                q.poll();

                checkMap[x][y] = true;

                for(int i =0; i<4; i++){
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if(nx<n && nx>=0 && ny<n && ny>=0 && !checkMap[nx][ny]){

                        if(st=='B' && map[nx][ny]=='B'){
                            q.add(nx);
                            q.add(ny);
                            checkMap[nx][ny] =true;
                        }else if((st=='G' || st=='R') && (map[nx][ny]=='G' || map[nx][ny]=='R')){
                            //System.out.println(nx+" " + ny);
                            q.add(nx);
                            q.add(ny);
                            checkMap[nx][ny] =true;
                        }
                    }
                }
            }

        }
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);


             n = Integer.parseInt(sc.nextLine());

            map = new char[n][n];
           checkMap = new boolean[n][n];


            for(int i =0; i<n; i++){
                String a = sc.nextLine();
                for(int j =0; j<n; j++){
                    map[i][j] = a.charAt(j);
                }
            }

            for(int i =0; i<n; i++){
                for(int j =0; j<n; j++){
                   if(!checkMap[i][j]){
                       normal(i,j);
                   }
                }
            }
            System.out.println(answer);

            answer=0;

            for(int i =0; i<n; i++){
                for(int j=0; j<n; j++){
                    checkMap[i][j] = false;
                }
            }

            for(int i =0; i<n; i++){
                for(int j =0; j<n; j++){
                    if(!checkMap[i][j]){
                        System.out.println(i+" " + j );
                        redgreen(i,j);
                    }
                }
            }

            System.out.println(answer);

        }
    }
