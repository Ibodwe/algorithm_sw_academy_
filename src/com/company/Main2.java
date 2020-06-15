package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {


    static char[] carray = {'+','-','*','/'};
    static ArrayList<Character> ch = new ArrayList<>();

    static int a,b,c;

    static void test(){
        String temp="";
        int tempNum=0;
        for(int i =0 ;i<carray.length; i++){
            if(i==0){
                temp = "+";
                tempNum = a+b;
            }else if (i==1){
                temp = "-";
                tempNum = a-b;
            }else if(i==2){
                temp = "*";
                tempNum = a*b;
            }else if(i==3){
                temp = "/";
                tempNum  =a/b;
            }
            if(tempNum==c){
                System.out.println(a+temp+b+"="+c);
            return;
            }
        }

        for(int i =0 ;i<carray.length; i++){
            if(i==0){
                temp = "+";
                tempNum = b+c;
            }else if (i==1){
                temp = "-";
                tempNum = b-c;
            }else if(i==2){
                temp = "*";
                tempNum = b*c;
            }else if(i==3){
                temp = "/";
                tempNum  =b/c;
            }
            if(tempNum==a){
                System.out.println(a+"="+b+temp+c);
                return;
            }
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

         a =  sc.nextInt();
         b = sc.nextInt();
         c = sc.nextInt();


         test();




    }
}
