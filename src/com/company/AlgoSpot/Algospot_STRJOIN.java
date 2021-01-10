package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Algospot_STRJOIN {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int C = Integer.parseInt(st.nextToken());

        for(int j=0; j<C; j++){

            st= new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine()," ");
            int answer = 0;

            for(int i =0; i<t; i++){
                pq.add(Integer.parseInt(st.nextToken()));
            }

            while (pq.size() > 1){
                int first = pq.poll();
                int second = pq.poll();
                answer += first+second;
                pq.add(first+second);
            }

            System.out.println(answer);

        }
    }
}
