package com.company.BackJoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BackJoon_1753 {

    // 다익스트라 주의사항 --> 가중치가 낮은 간선 순서 대로 뽑아 준다.
    // 값이 변경 되는 것 만 queue에 넣어준다.
    static int[] answer;
    static int v;
    static int start;
    static ArrayList<ArrayList<edge>> data;
    static StringBuilder sb = new StringBuilder();
    static public void shrtDistance(){
        PriorityQueue<edge> q = new PriorityQueue<>();

        q.add(new edge(start,0,false));
        answer[start] = 0;

        while (!q.isEmpty()){
            int st = q.peek().ed;
            // System.out.println(st+"st");
            q.poll();
            //순환 하면서 값이 변동 될 여지가 남아 있음

            for(int i =0; i<data.get(st).size(); i++){
                int di = data.get(st).get(i).ed;
                int weight = data.get(st).get(i).weight;
                boolean used = data.get(st).get(i).used;

                if(!used){
                    data.get(st).get(i).used = true;

                    if(answer[di] > answer[st] + weight){
                        answer[di] = Math.min(answer[di] , answer[st] + weight);
                        q.add(new edge(di , answer[di], false));
                    }

                }

            }

        }

        for(int i =1; i<=v; i++) {
            if (answer[i] == 20000000) {
                sb.append("INF");
            } else {
                sb.append(answer[i]);
            }
            sb.append('\n');
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        answer = new int [v+1];

        for(int  i = 0 ; i<=v; i++){
            answer[i] = 20000000;
        }

        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        data = new ArrayList<>();

        //init data
        for(int i =0; i<=v; i++){
            ArrayList<edge> temp = new ArrayList<>();
            data.add(temp);
        }

        for(int i=0; i<e; i++){
            String[] strs = br.readLine().split("\\s");
            int a = Integer.parseInt(strs[0]);
            int b =  Integer.parseInt(strs[1]);
            int c =  Integer.parseInt(strs[2]);

            data.get(a).add(new edge(b,c,false));
        }

        shrtDistance();
        //start에서 나머지로 가는 최단 경로 구하기..!

        bw.write(sb.toString());
        bw.flush();
    }

    static class edge implements Comparable<edge>{
        int ed;
        int weight;
        boolean used;
        public edge(int ed, int weight , boolean used){
            this.ed =ed;
            this.weight= weight;
            this.used = used;
        }

        @Override
        public int compareTo(edge o) {
            return this.weight - o.weight;
        }
    }
}







