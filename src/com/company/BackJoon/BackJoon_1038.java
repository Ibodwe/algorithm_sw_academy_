package com.company.BackJoon;


import java.util.*;


public class BackJoon_1038 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Long> q = new LinkedList<>();

        int count =0;
        if(n < 10){
            System.out.println(n);
        }else{
            for(int i =1; i<10; i++){
                q.add((long)i);
            }
            long answer = 0;
            count = 9;
            answer = -1;
            while(count != n){

                if(!q.isEmpty()){
                    long k = q.poll();
                    //무조건 10의자리 보다 작으면 들어가고 아니면

                    long middle = k % 10;

                    for(int i =0; i < middle; i++){
                        q.add(k*10 + i);
                        count++;

                        if(count==n){
                            answer = k*10+i;
                            break;
                        }
                    }
                }else{
                    break;
                }
            }

            System.out.println(answer);
        }

    }






}
