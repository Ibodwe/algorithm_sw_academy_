package com.company.normal_algorithm_implemention;

import java.util.Arrays;

public class revolvingArray {


    static public void revolve(int [] arr, int n){
        int firstNum = arr[0];

        for(int i =1; i < n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = firstNum;
    }


    static public void juggleRevolve(int [] arr , int d ,int n){

        for(int i = 0; i < d; i++){
            int temp = arr[i];

            for(int j = i; i<n; i++){
                
            }

        }

    }

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6};

        for(int i =0; i<3; i++){
             revolve(arr, arr.length);
          System.out.println( Arrays.toString(arr));
        }



    }
}
