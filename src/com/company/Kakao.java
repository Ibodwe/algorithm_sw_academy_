package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kakao {


    public static void main(String[] args) {
       String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        HashMap<String, Integer> gemMap = new HashMap<>();

        int start = 100001;
        int end = 100001;

        
       for(int i=0; i< gems.length; i++){
           String temp = gems[i];

           if(!gemMap.containsKey(temp)){
               gemMap.put(temp,1);
           }else{
               int num = gemMap.get(temp);
               gemMap.put(temp,num+1);
           }
       }

        for(int i =gems.length-1; i>=0; i-- ){
            String temp = gems[i];

            int num = gemMap.get(temp);

            if(num>1){
                gemMap.put(temp,num-1);
            }else{
                end = i+1;
                break;
            }
        }

       for(int i =0; i< gems.length; i++){
           String temp = gems[i];

           int num = gemMap.get(temp);

           if(num >1){
               gemMap.put(temp,num-1);
           }else{
               start = i+1;
               break;
           }

       }




       System.out.println(start+" " + end);

    }

}
