package com.company.BackJoon;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BackJoon_1068   {


    static ArrayList<Integer>[] map ;
    static int n;
    static boolean [] visited;

    static public void pruneMap(int parent){


        ArrayList<Integer> temp = map[parent];
        visited[parent] = true;

        for(int i =0; i<temp.size(); i++){
            if(!visited[map[parent].get(i)]){
                pruneMap(map[parent].get(i));
            }
        }


    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");


        n = Integer.parseInt(st.nextToken());
        //init map

        map = new ArrayList[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine()," ");

        for(int i =0; i<n; i++){
            map[i] = new ArrayList<>();
        }

        for(int i =0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num!=-1){
                map[num].add(i);
            }

        }

        st = new StringTokenizer(br.readLine()," ");

        int ta =  Integer.parseInt(st.nextToken());

        int count =0;

        pruneMap(ta);

        for(int i =0; i<n; i++){

            for(int j=map[i].size()-1; j>=0; j--){
                if(visited[map[i].get(j)]){
                    map[i].remove(j);
                }
            }
        }

        for(int i =0; i<n; i++){

            if(!visited[i] && map[i].size()==0){
                //System.out.println(i);
                count++;
            }

        }

        System.out.println(count);


    }
}
