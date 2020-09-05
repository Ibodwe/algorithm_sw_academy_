package com.company.BackJoon;


import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;


public class BackJoon_2947 {

    static int [] map = new int[5];
    static boolean swap(int a, int b){
        if(map[a] > map[b] ){
            int temp = map[a];
            map[a] = map[b];
            map[b] = temp;
            return true;
        }

        return false;
    }

    static public void print(){
        for(int i =0; i<5; i++){
            System.out.print(map[i]+" ");
        }
        System.out.println();

    }




    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int index = 0;
        while(st.hasMoreTokens()){
            map[index++] = Integer.parseInt(st.nextToken());
        }


        while(true){
            boolean check = false;
            boolean check2 = false;
            for(int i =0; i<4; i ++){
                check = swap(i,i+1);
                if(check) {
                    check2=true;
                    print();
                }

            }


            if(!check2){
                break;
            }
        }


    }
}


