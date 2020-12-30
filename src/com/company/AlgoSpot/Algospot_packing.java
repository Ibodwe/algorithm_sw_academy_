package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algospot_packing {

    static String[] nameArray ;
    static int[] value;
    static int[] weight;

    static int[] answerValue;
    static int[] answerWeight;

    static int[][] cache;
    static int n;
    static int w;

    static public int getAnswer(int capacity, int item ){

        if(item == n){
            return 0;
        }

        int ret = cache[capacity][item];

        if(ret!=0){
            return ret;
        }

        ret = getAnswer(capacity, item+1);

        if(capacity >= weight[item]){
            ret = Math.max(ret , getAnswer(capacity-weight[item] , item+1) + value[item]);

        }

        return ret;
    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int C = Integer.parseInt(st.nextToken());

        for(int i =0; i<C; i ++){

            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            cache = new int [n][w];

            nameArray = new String[n];
            value = new int[n];
            weight = new int[n];

            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine(), " ");
                nameArray[j] = st.nextToken();
                value[j] = Integer.parseInt(st.nextToken());
                weight[j] = Integer.parseInt(st.nextToken());
            }

            int answer = getAnswer(w,0);

            for(int k=0; k<w; k++){
                System.out.println(cache[n][0]);
            }



        }


    }
}
