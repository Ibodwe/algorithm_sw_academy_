package com.company.BackJoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1339   {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] alpa = new int [26];
        boolean [] visit = new boolean[26];
        String [] map = new String[n];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            map[i] = t;
            int weight = 1;

            for(int j=t.length()-1; j>=0; j--){
                char s =  t.charAt(j);
                int p = s-65;
                alpa[p] += weight;
                weight*=10;
            }
        }

        for(int j=9; j>=0; j--){
            int max =0;
            int maxIndex = 0;
            boolean check= false;

            for(int i =0; i< 26; i++){

                if(max < alpa[i] && !visit[i]){
                    maxIndex = i;
                    max = alpa[i];
                    check = true;
                }

            }

            if(check){
                visit[maxIndex] = true;
                alpa[maxIndex] = j;
            }

        }
        int answer = 0;

        for(int i =0; i < n; i++){
            int an = 0;
            String temp = map[i];

            for(int j =0; j<temp.length(); j++){
                int k = alpa[temp.charAt(j)-65];
                an*=10;
                an+=k;
            }

            answer+=an;
        }

        System.out.println(answer);



    }
}
