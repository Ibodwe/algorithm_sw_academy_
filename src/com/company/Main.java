package com.company;


import javax.print.attribute.HashAttributeSet;
import java.util.*;


public class Main {


    static int n =0;
    static int m = 0;
    static int answer= 0;
    static int [][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    static int [][] temp;
    static Stack<Integer> xSt = new Stack<Integer>();
    static Stack<Integer> ySt = new Stack<Integer>();

    static public void solution(int count, int [][]map){

        if(count==3){
            //체크하는 코드
            for(int i =0; i<n; i++){
                for(int j =0; j<m; j++){
                    temp[i][j] = map[i][j];
                }
            }

            checkMap(temp);

            return;
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    solution(count+1,map);
                    map[i][j] = 0;
                }
            }
        }
    }

    static public void checkMap(int [][]valueMap){
        boolean change = true;

        while(change){
         change=false;
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(valueMap[i][j]==2){
                    for(int k=0; k<4; k++){

                        int x = direction[k][0] + i;
                        int y = direction[k][1] + j;

                        if(checkValue(x,y)){
                            if(valueMap[x][y]==0){
                            change = true;
                            xSt.add(x);
                            ySt.add(y);
                            }
                        }
                    }

                }
            }
        }

        while(!ySt.isEmpty()){
            int a = xSt.peek();
            int b = ySt.peek();
            valueMap[a][b] = 2;
            xSt.pop();
            ySt.pop();
        }

        if(!change){
            int count = 0;
            for(int i =0; i<n; i++){
                for(int j =0; j<m; j++){
                    if(valueMap[i][j]==0){
                        count++;
                    }
                }
            }
            answer = Math.max(answer,count);
        }

        }

    }

    static public boolean checkValue(int a, int b){

        if(a < 0 || a >= n || b < 0 || b >= m){
            return false;
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

         n = sc.nextInt();
         m = sc.nextInt();

        int [][] maps = new int [n][m];
            temp = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                maps[i][j] = sc.nextInt();
            }
        }
        solution(0 , maps);



        System.out.println(answer);
        // 0에 최대한 i를 배치 하고
        // 바이러스가 전부 퍼질때 까지 배치
        //

    }


}
