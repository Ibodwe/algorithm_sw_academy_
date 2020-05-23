package com.company;


import java.util.LinkedList;
import java.util.Queue;

public class codingTest {
    public static void main(String[] args) {

        String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
        //12월 31일 까지의 등급
        int[] answer = new int[5];
        int[] monthDay = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        Queue<Member> meme = new LinkedList<>();
        // 31 28 31 30 31 30 31 31 30 31 30 31
        for(int i=0; i< purchase.length; i++){

            String[] a= purchase[i].split(" ");
            int month = Integer.parseInt(a[0].substring(5,7));
            int day = Integer.parseInt(a[0].substring(8,10));
            int price = Integer.parseInt(a[1]);

            int temp = 0;
            for(int j =1; j<month; j++){
                        temp += monthDay[j];
            }

            temp += day;

            //System.out.println(temp);
       //     System.out.println(temp);
            meme.add(new Member(price,temp,temp+30));
        }


        Queue<Integer> qu = new LinkedList<>();
        Queue<Integer> quend = new LinkedList<>();

        int firstDay = 0;
        int currentDay =1;
        int price = 0;
        int popDay = 0;
        int value = 0;
        int priceStack =0;

        while(currentDay <= 365){
           // System.out.println(priceStack  +"value " +value +" current " +currentDay );
            if(!meme.isEmpty()){

            if(meme.peek().day == currentDay){
                 firstDay = meme.peek().day;
                 priceStack += meme.peek().price;
                 qu.add(meme.peek().price);
                 quend.add(firstDay+30);

                meme.poll();
            }

            }

                //System.out.println(quend.peek()+"qeqe");
            if(!quend.isEmpty()){
            if(currentDay == quend.peek()){
                quend.poll();
                 value = qu.peek();
                priceStack -= value;
                qu.poll();
            }
            }



            if(priceStack<10000){
                answer[0]++;
            }else if(priceStack<20000){
                answer[1]++;
            }else if(priceStack<50000){
                answer[2]++;
            }else if (priceStack<100000){
                answer[3]++;
            }else{
                answer[4]++;
            }

            currentDay++;

        }
        for(int i =0; i<5; i++){
            System.out.println(answer[i]);
        }




    }

    static class Member{

        int price;
        int day ;
        int finishDay;
                public Member(int price, int day , int finishDay){
            this.day = day;
            this.price= price;
            this.finishDay = finishDay;
                }
    }
}
