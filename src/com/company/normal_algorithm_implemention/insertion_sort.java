package com.company.normal_algorithm_implemention;

import java.util.Arrays;

public class insertion_sort {

    static public void swap(int a , int b , int [] array){

        if(array[a] > array[b]){
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

    }

    public static void main(String[] args) {

        int [] array = {2,5,7,1,1,2,42};


        for(int i =1; i< array.length; i++){
            int temp = array[i];
            int prev = i-1;

            while(prev>=0 && array[prev] > temp){
                //뒤로 옮기기
                array[prev+1] = array[prev];
                prev--;
            }

            array[prev+1] = temp; 
        }
        System.out.println(Arrays.toString(array));

    }
}
