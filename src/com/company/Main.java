package com.company;


import javax.print.attribute.HashAttributeSet;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] people = new int[n];

        for(int i =0; i<n; i++){
            people[i] = sc.nextInt();
        }

        int B = sc.nextInt();
        int C = sc.nextInt();

        long answer = 0L;

        for(int i =0; i<n ; i++){

            int currentPeople = people[i];

            if(B >= currentPeople){
                answer+=1;
            }else{
                answer++;
                currentPeople -= B;

                long number = currentPeople / C;
                long dive = currentPeople % C;

                if(dive>0){
                    answer+=1;
                }
                answer = (long)answer + number;

            }

        }

        System.out.println((long)answer);

    }


}
