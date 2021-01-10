package com.company.AlgoSpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Algospot_ALLERGY {


    static ArrayList<String> names = new ArrayList<>();

    static int [][] map;
    static int W;
    static int H;
    static int answer = 99999999;
    static Boolean [] foodMap;
    static int [][] foodNumInt;



   static public void search(int currentDishIndex , int [] eat ,int dishNum){

        if(answer<= dishNum){
            return;
        }
        //모든 음식이 체크 되었 는지 아닌지 체크

        if(currentDishIndex == W){

        for(int i =0; i<eat.length; i++){
            if(eat[eat.length - 1] > 0 && i ==eat.length - 1 ){
                answer = Math.min(answer, dishNum);
                return;
            }else if (eat[i]<=0){
                return;
            }
        }
        }

        search(currentDishIndex+1 , eat, dishNum);

        // 전체 음식을 돌아 가면서 선택
            for(int j =0; j<H; j++){
                if(map[j][foodNumInt[currentDishIndex][0]]==1){
                    eat[j]++;
                }
            }
                foodMap[foodNumInt[currentDishIndex][0]] = true;
                search(currentDishIndex+1 ,eat, dishNum+1);

        for(int j =0; j<H; j++){
            if(map[j][foodNumInt[currentDishIndex][0]]==1){
                eat[j]--;
            }
        }

       foodMap[foodNumInt[currentDishIndex][0]] = false;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int T = Integer.parseInt(st.nextToken());

        for(int j=0; j<T; j++){
            st = new StringTokenizer(br.readLine() , " ");
            names.clear();

            answer = 999999999;

             H = Integer.parseInt(st.nextToken());
             W = Integer.parseInt(st.nextToken());
            foodNumInt = new int[W][2];

             int [] eat = new int [H];
            map = new int[H][W];
            foodMap = new Boolean[W];

            st = new StringTokenizer(br.readLine() , " ");

            for(int i =0; i<H; i++){
                eat[i] = 0;
                names.add(st.nextToken());
            }

            for(int i =0; i<W; i++){
                st = new StringTokenizer(br.readLine() ," ");
                int c = Integer.parseInt(st.nextToken());

                foodNumInt[i][1] = c;
                foodNumInt[i][0] = i;

                for(int k=0; k<c; k++){
                    int m =names.indexOf(st.nextToken());

                    map[m][i] = 1;
                }
                foodMap[i] = false;
            }

            Arrays.sort(foodNumInt, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });

            for(int i =0; i<foodNumInt.length; i++){
                System.out.println(foodNumInt[i][0] + " " + foodNumInt[i][1]);
            }

            search(0,eat,0);

            System.out.println(answer);


        }
    }
}
