    package com.company;


    public class Main3 {

        public static void main(String args[]) {

            int num = 3;
            int []dp = new int [100001];
            int [] cards = {17};

            for(int i =0; i<=num; i++){
                dp[i] = 9999999;
            }

            for(int i =0; i< cards.length; i++){
                dp[cards[i]] =1 ;
            }

            for(int i =1; i <= num; i++){
                for(int j =0; j< cards.length; j++){
                    if(i - cards[j] > 0 ){
                        dp[i] = Math.min(dp[i-cards[j]] , dp[i]);
                    }
                }
                dp[i]++;
            }

            for(int i =1; i<=num; i++){
                System.out.println("i "+i+" " + dp[i]);
            }


        }

        }