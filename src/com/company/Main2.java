package com.company;


import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;


public class Main2 {


    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nubmer = Integer.parseInt(br.readLine());

        String [] base = br.readLine().split("[.]");

        int limit = base.length-1;

        for(int i=1; i<nubmer;i ++){
            String [] target = br.readLine().split("[.]");

            int k =0;

            while(k < limit && k < target.length-1){
                if(base[k].equals(target[k])){
                    k++;
                    continue;
                }else{
                    limit = Math.min(limit,k);
                    break;
                }

            }
            limit = Math.min(limit,k);
        }

        StringBuilder sb = new StringBuilder();
        if(limit<=1){
            System.out.println("없음");
        }else{
            for(int i =0; i<limit;i++){
                sb.append(base[i]);
                if(i!=limit-1) {
                    sb.append(".");
                }
            }
            System.out.println(sb);
        }

    }
    }


