package com.company.BackJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class BackJoon_2580 {


    static int [][] sdoku = new int [9][9];

    static public boolean solve(){

        for(int i =0; i<9; i++){
            for(int j =0; j<9;j++){
                if(sdoku[i][j]==0){

                    for(int k=1; k<10; k++){
                        if(check(i,j,k)&& check2(i,j,k) ){
                            //  System.out.println("i " + i + " j " + j + " k " + k);
                            sdoku[i][j] = k;
                            boolean ch = solve();
                            if(!ch){
                                sdoku[i][j]=0;
                            }
                        }
                    }

                    if(sdoku[i][j]==0){
                        return false;
                    }

                }
            }
        }

        return true;

    }

    static public boolean check(int w, int h ,int k ){
        boolean [] numCheck = new boolean[10];
        boolean [] numCheck2 = new boolean[10];
        //w check
        // sdoku[w][h] = k;

        for(int i =0; i<9; i++){
            int num = sdoku[w][i];
            if(k==num){
                return false;
            } else if(!numCheck[num]){
                numCheck[num] = true;
            }else if(numCheck[num] && num!=0){
                //    sdoku[w][h] = 0;
                return false;
            }
        }

        for(int i =0; i<9; i++){
            int num = sdoku[i][h];
            if(k==num){
                return false;
            } else if(!numCheck2[num]){
                numCheck2[num] = true;
            }else if(numCheck2[num] && num!=0){
                //   sdoku[w][h] = 0;
                return false;
            }
        }
        return true;

    }

    static public boolean check2(int h, int w, int k ){
        int width = w/3;
        int height = h/3;
        //  sdoku[h][w] = k;
        boolean [] numCheck = new boolean[10];

        for(int i = width*3; i<width*3+3; i++){
            for(int j =height*3; j<height*3+3; j++ ){
                int num = sdoku[j][i];
                if(k==num){
                    return false;
                }
                if(!numCheck[num]){
                    numCheck[num]= true;
                }else if(numCheck[num] && num!=0){
                    return false;
                }
            }
        }

        return true;
    }

    static public void print(){
        System.out.println();
        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                System.out.print(sdoku[i][j]+" ");

            }
            System.out.println();
        }
    }


    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;


        for(int i =0; i<9; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j<9; j++){
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        print();

    }



}
