package com.company;


import java.util.*;


public class SamSung_Swacademy_5656 {

    static ArrayList<Integer> array = new ArrayList<>();
    static int answer = 99999;
    static int W;
    static int H;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;

    static void makePair(int w, int n, int count) {

        if (array.size() == n) {
            // 실행
            calBlocks(array);
            return;
        }

        for (int i = 0; i < w; i++) {
            array.add(i);
            makePair(w, n, count + 1);
            array.remove(array.size() - 1);
        }


    }

    static void calBlocks(ArrayList<Integer> ar) {

        int[][] temp = new int[H][W];


        //항상 맵 초기화
        for (int n = 0; n < H; n++) {
            for (int m = 0; m < W; m++) {
                int num = map[n][m];
                temp[n][m] = num;
            }
        }

//        System.out.println(" temp ");
//        for (int n = 0; n < H; n++) {
//            for (int m = 0; m < W; m++) {
//                System.out.print(temp[n][m] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < ar.size(); i++) {
            //i 번째에 공을 떨어트리는거
            int start = ar.get(i);
            for (int j = 0; j < H; j++) {
                if (temp[j][start] != 0) {
                    bfs(temp, j, start, temp[j][start]);
                    break;
                }
            }

        }

        int countt = 0;
        //맵에 남은 숫자 세기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (temp[i][j] != 0) {
                    countt++;
                }
            }
        }
        answer = Math.min(answer, countt);

    }

    static boolean isValid(int a, int b) {
        if (a < 0 || a >= H || b < 0 || b >= W) {
            return false;
        }
        return true;
    }

    static void bfs(int[][] map2, int x, int y, int l) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(x);
        qu.add(y);
        qu.add(l);
        map2[x][y] = 0;


        while (!qu.isEmpty()) {
            int nX = qu.peek();
            qu.poll();
            int nY = qu.peek();
            qu.poll();
            int nl = qu.peek();
            qu.poll();


            for (int i = 0; i < 4; i++) {
                int nnX = nX;
                int nnY = nY;
                for (int j = 0; j < nl-1; j++) {
                    nnX += dir[i][0];
                    nnY += dir[i][1];
                    if (isValid(nnX, nnY) && map2[nnX][nnY] != 0) {
                        qu.add(nnX);
                        qu.add(nnY);
                        qu.add(map2[nnX][nnY]);
                        map2[nnX][nnY] = 0;
                    }
                }

            }
        }


        //맵은 떨어지는거기 때문에 밑에서부터 위로 정리..!
        for (int i = H - 2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if (map2[i][j] != 0) {
                    int height = i;

                    while (height < H){
                        //한번씩하자 한번씩..!
                        int neH = height+1;
                        if(isValid(neH,j) && map2[neH][j]!=0){
                            break;
                        }else if(isValid(neH,j) && map2[neH][j]==0){
                            int num = map2[height][j];
                            map2[neH][j] = num;
                            map2[height][j] = 0;
                            height++;
                        }else{
                            break;
                        }
                    }

                }

            }
        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());



        for (int i = 1; i <= T; i++) {
            String[] a = sc.nextLine().split(" ");
            answer=99999;
            int N = Integer.parseInt(a[0]);
            W = Integer.parseInt(a[1]);
            H = Integer.parseInt(a[2]);
            map = new int[H][W];
            array.clear();

            for (int j = 0; j < H; j++) {
                String[] ab = sc.nextLine().split(" ");
                for (int k = 0; k < W; k++) {
                    map[j][k] = Integer.parseInt(ab[k]);
                }

            }
//
//            for (int j = 0; j < H; j++) {
//                for (int k = 0; k < W; k++) {
//                    System.out.print(map[j][k] + " ");
//                }
//                System.out.println();
//            }
            makePair(W, N, 0);

            System.out.println("#"+i+" "+answer);

        }
    }
}

