
package com.company.BackJoon;
import java.util.*;

public class BackJoon_13549 {

    static int n;
    static int m;
    static int answer = 99999999;
    static boolean[] check = new boolean[200020];
    static int[] anMap = new int[200020];
    static Queue<People> q = new LinkedList<>();

    static public void mm (int currentNum , int value ){

        q.add(new People(currentNum,0));
        check[currentNum] = true;
        while (!q.isEmpty()){
            int cost = q.peek().value;
            int num =  q.peek().num;
            q.poll();
            check[num] = true;

            if(num == m ){
                answer = Math.min(answer,cost);
            }

            if(num*2 <=100000 && !check[num*2]){
                q.add(new People(num*2,cost));
            }

            if(num+1 <= 100000 && !check[num+1]){
                q.add(new People(num+1,cost+1));
            }

            if(num-1 >= 0 && !check[num-1]){
                q.add(new People(num-1,cost+1));
            }


        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();


        mm(n,0);
        System.out.println(answer);
    }

    static class People{
        int num;
        int value;
        public People(int num, int value){
            this.num = num;
            this.value = value;
        }
    }



}







