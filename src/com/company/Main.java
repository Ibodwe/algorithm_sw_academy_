package com.company;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int [][] direct = {{1,0},{-1,0},{-1,0},{0,1}};

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=1; i<=T; i++){
            int N = sc.nextInt();

            ArrayList<atom> at = new ArrayList<>();

            for(int j =0; j<N; j++){
                int x= sc.nextInt();
                int y = sc.nextInt();
                int di = sc.nextInt();
                int en = sc.nextInt();
                at.add(new atom(x,y,di,en));
            }
            //--> 이동으로 가까워지고 있는지 아닌지를 확인해야함..!
            //--> x,y 기준으로 정렬..!


        }


    }

    static class atom{
        int x;
        int y;
        int dir;
        int energy;

        public atom(int x, int y, int dir, int energy){
            this.x = x;
            this.y = y;
            this.dir= dir;
            this.energy = energy;

        }
    }


    }


