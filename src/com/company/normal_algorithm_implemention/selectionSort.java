package com.company.normal_algorithm_implemention;


import java.util.Arrays;

import static com.company.normal_algorithm_implemention.bubbleSort.swap;


public class selectionSort {

    // 제일 작은 값을 선택 한다.
    // 제일 작은 값을 index와 바꾼다.

    static public void swap(int a , int b , int [] array){

        if(array[a] > array[b]){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

    }



    public static void main(String[] args) {

        int [] array = {2,5,7,1,1,2,42};

        for(int i =0; i < array.length; i++){
            int minNumIndex = i;

            for(int j = i; j < array.length; j++){

                if(array[minNumIndex]>array[j]){
                    minNumIndex = j;
                }

            }

            swap(i, minNumIndex, array);

        }
        System.out.println(Arrays.toString(array));

    }
}
