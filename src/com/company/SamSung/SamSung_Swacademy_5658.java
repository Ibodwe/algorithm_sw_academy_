package com.company.SamSung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SamSung_Swacademy_5658 {


   static public Double makeHex(String a){

        Double answer = 0.0;

   //    System.out.println(a);
        int index = 0;
        for(int i =a.length()-1; i>=0; i--){
            Double b = Math.pow(16, index);
            Double num = 0.0;
            if(a.charAt(i)=='A'){
                num = 10.0;
            }else if(a.charAt(i)=='B'){
                num = 11.0;
            }else if(a.charAt(i)=='C'){
                num = 12.0;
            }else if(a.charAt(i)=='D'){
                num = 13.0;
            }else if(a.charAt(i)=='E'){
                num = 14.0;
            }else if(a.charAt(i)=='F'){
                num = 15.0;
            }else{
                num = (double)a.charAt(i);
                num -=48;
            }
           // System.out.println("b " + b);
          //  System.out.println("num " + num);
            answer+= num*b;
            index++;
        }

      //  System.out.println("answer " + answer);
        return answer;

    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        ArrayList<Double> num = new ArrayList<Double>();
        ArrayList<String> map = new ArrayList<>();

        int T = Integer.parseInt(sc.nextLine());

        for(int i =1; i<= T; i ++){
            map.clear();
            num.clear();
            String[] a = sc.nextLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int K = Integer.parseInt(a[1]);

            String tt = sc.nextLine();

            StringBuilder numbers = new StringBuilder(tt);

            for(int jj= 0 ; jj<numbers.length()/4; jj++){

            for(int j=0; j< numbers.length(); j+= numbers.length()/4) {
                //0~N/4개 까지 끊어서...!
                String s = numbers.substring(j, j + numbers.length() / 4);

                if (!map.contains(s)) {
                    map.add(s);
                }
            }

                char temp = numbers.charAt(numbers.length()-1);

                for(int k=numbers.length()-1; k > 0; k--){
                    char ch = numbers.charAt(k-1);
                    numbers.setCharAt(k,ch);
                }
                numbers.setCharAt(0,temp);
                //여기서 변수들 바꿔줘야함..!
            }

            for(int kk=0; kk<map.size(); kk++){
                Double t  = makeHex(map.get(kk));
                num.add(t);
            }

            Collections.sort(num,Collections.reverseOrder());

            double b = num.get(K-1);
            long anan = (long)b;

            System.out.println("#"+i+" " + anan);


        }


        }


    }

