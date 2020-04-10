package com.company;


import java.util.*;

/*
*
* */
public class Main {

    public static void main(String[] args) {
        // write your code here

        //입력



        for (int i = 1; i <= 10; i++) {
            Scanner sc = new Scanner(System.in);

            int num  = sc.nextInt();

            int[] buildings = new int[num];
            int answer = 0;

            for (int j = 0; j < num; j++) {
                int height = sc.nextInt();
                buildings[j] = height;

            }

                for (int k = 0; k < num; k++) {
                    //k가 array의 인덱스를 초과하면 안되기 때문에 continue;
                    if (k - 2 < 0 || k + 2 >= num) {
                        continue;
                    } else {
                        //왼쪽, 오른쪽을 비교, 비교 방법은 왼쪽과 오른쪽 2개의 높이중 가장 큰 높이를 선택 후 선택한 높이에서 뺸다.
                        int currentHeight = buildings[k];
                        int left = Math.max(buildings[k - 1], buildings[k - 2]);
                        int right = Math.max(buildings[k + 1], buildings[k + 2]);
                        int bestHeightBuilding = Math.max(left, right);

                        if (currentHeight - bestHeightBuilding > 0) {
                            answer += currentHeight - bestHeightBuilding;

                        }

                    }

                }

            System.out.println("# "+i+" "+answer);
            }

        }
    }

