package com.company;


import java.util.*;

/*
*g
* */
public class Main {

    public static void main(String[] args) {
        // write your code here

        //입력
        Scanner sc = new Scanner(System.in);

            for(int i =1; i<=10;i++){
                String input = sc.nextLine();
                int dumpNum = Integer.parseInt(input);

                int [] boxes = new int[100];
                String [] dummy = sc.nextLine().split(" ");


                for(int j =0; j<100; j++){
                    boxes[j] = Integer.parseInt(dummy[j]);
                }
                Arrays.sort(boxes);

                while(dumpNum>0){
                    //제일 쉽게 짤 수 있는 g방법 --> 제일 위쪽에서 뺴서 제일 앞쪽에 더하는것
                    boxes[0]++;
                    boxes[99]--;
                    dumpNum--;
                    Arrays.sort(boxes);

                    if(boxes[0]==boxes[99]){
                        break;
                    }

                    if(boxes[0]+1==boxes[99]){
                        break;
                    }
                }
                int answer = boxes[99]-boxes[0];
                System.out.println("#"+i+" "+ answer);
            }

        }
    }

