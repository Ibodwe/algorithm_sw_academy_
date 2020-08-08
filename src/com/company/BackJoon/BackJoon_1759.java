package com.company.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BackJoon_1759 {

    static int L;
    static int C;
    static char [] map ;

    static char [] answer;
    static public void print(int count ,boolean include, int index){


        if(count == L){
            StringBuilder st = new StringBuilder();
            boolean chaeiou = false;
            int jaumCount =0;
            for(int i =0; i<L; i++){
                if(answer[i]=='a'||answer[i]=='i'||answer[i]=='o'||answer[i]=='u'||answer[i]=='e'){
                    chaeiou = true;
                }else{
                    jaumCount++;
                }
                st.append(answer[i]);
            }

            if(chaeiou && jaumCount > 1){
                System.out.println(st);
            }
            return;
        }

        //a c i s t w

        for(int i = index; i< map.length; i++){
            answer[count] = map[i];
            print(count+1, include,i +1 );

        }
    }

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        map = new char[C];

        for(int i =0; i<C; i++){
            map[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(map);

        answer = new char[C];


        print(0,false,0);


    }



}
