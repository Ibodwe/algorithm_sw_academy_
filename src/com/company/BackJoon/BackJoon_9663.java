package com.company.BackJoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BackJoon_9663 {

    static int[][] map;
    static  int n;
    static int answer;
    public static  void nQueen(int a, int count ){

        if(count == n){
            System.out.println();
            answer++;
            return;
        }
        //가로 중 어디에 놓을지만 결정..! 1줄에 1개 값만 올 수 있다는게 정설
        for(int j =0; j<n; j++){
            if(row(a) && col(j) && dir(a, j)){
                //   System.out.println("x " + a+" y " + j );
                map[a][j] =1;
                nQueen(a+1,count+1);
                map[a][j] =0;
            }

        }

    }

    public static  boolean row(int c){
        for(int i =0; i<n; i++){
            if(map[c][i]==1){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }

    public static boolean col(int c ){
        for(int i =0; i<n; i++){
            if(map[i][c]==1){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }

    public static boolean dir(int x, int y){
        //  System.out.println("dir " + x+" "+ y);
        int a = x;
        int b = y;
        while (true){
            a++;
            b++;
            if(a >=n || b>= n){
                break;
            }else{
                if(map[a][b] == 1){
                    return false;
                }
            }
        }

        a = x;
        b = y;

        while (true){
            a--;
            b--;
            if(a <0 || b< 0){
                break;
            }else{
                if(map[a][b] == 1){
                    return false;
                }
            }
        }

        a = x;
        b = y;

        while (true){
            a++;
            b--;
            if(a>=n || b<0){
                break;
            }else{
                if(map[a][b]==1){
                    return false;
                }
            }
        }

        a = x;
        b = y;

        while (true){
            a--;
            b++;
            if(a<0 || b>=n){
                break;
            }else{
                if(map[a][b]==1){
                    return false;
                }
            }
        }

        return true;

    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int [n][n];

        nQueen(0,0);

        System.out.println(answer);
    }

}







