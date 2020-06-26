package com.company.BackJoon;

import java.util.*;

public class BackJoon_1092 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int [] crane = new int [n];

        for(int i =0; i<n; i++)
            crane[i] = sc.nextInt();

        int m = sc.nextInt();

        int answer = 0;

        ArrayList<Integer> boxes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();


        for(int i =0; i < m; i++){
            int nn = sc.nextInt();
            boxes.add(nn);
        }


        Collections.sort(boxes);
        Arrays.sort(crane);

        int count = 0;
        if(boxes.get(m-1) > crane[n-1]){
            System.out.println(-1);
        }else{

            while (boxes.size()!=0){
                int index = n-1;

                for(int i= boxes.size()-1; i>=0; i--) {
                    if(index ==-1){
                        break;
                    }

                    int target = boxes.get(i);
                    if(crane[index] >= target) {
                        boxes.remove(i);
                        index--;
                    }

                }

                answer++;
            }


            System.out.println(answer);



        }


    }
}
