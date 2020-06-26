package com.company.BackJoon;




import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon_1946 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i =0; i<t; i++){
            int k = sc.nextInt();
            Employee [] map  = new Employee[k];

            for(int j =0; j<k; j++){
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                map[j] = new Employee(temp1,temp2);
            }

            Arrays.sort(map);
            int answer =1;
            int bound = map[0].score1;

            for(int p =1; p<k; p++){
                if(bound > map[p].score1){
                    bound = map[p].score1;
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }

    static public class Employee implements Comparable<Employee> {
        int score1=0;
        int score2=0;
        public Employee(int a, int b){
            score1 = a;
            score2 = b;
        }

        @Override
        public int compareTo(Employee o) {
            return  this.score2 - o.score2;
        }
    }
}


