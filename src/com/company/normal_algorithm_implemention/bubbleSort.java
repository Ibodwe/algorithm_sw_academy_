package com.company.normal_algorithm_implemention;

import java.util.Arrays;

public class bubbleSort {

    // bubble Sort --> 옆에 있는 숫자가 작다면 제일 뒤로 보내주는 방법으로 정렬
    // n(n-1 + n-2 + ...0)
    //  n(n-1)/2
    // 즉 시간복잡도 : n^2 , 공간 복잡도 : n

   static public void swap(int a , int b , int [] array){

        if(array[a] > array[b]){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

    }

    public static void main(String[] args) {

        int [] array = {2,5,7,1,1,2,42};

        for(int i =0; i<array.length; i++){

            // 한번 수행 될 때마다 제일 작은 값이 보장되기 때문에 불필요하게
            // n-i 번 뒤로 갈 필요 없다.
            for(int j =1; j<array.length-i; j++){

                swap(j-1,j,array);
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
