package com.company.BackJoon;



import java.util.Scanner;
import java.util.Stack;

public class BackJoon_1389 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] map = new int[n][n];
        int [] answerMap = new int [n];
        int [] graphMap = new  int [n];
        Stack<Integer> st = new Stack<>();

        for(int i =0; i<m; i++){
            //연결
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a-1][b-1] = 1;
            map[b-1][a-1] = 1;
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(map[i][j]==1){
                    graphMap[j] = map[i][j];
                    st.add(j);
                }else{
                    graphMap[j] = 999999;
                }
            }
            graphMap[i] = 0;

            while(!st.isEmpty()){
                int targetNum = st.peek();
                st.pop();
                for(int k =0; k<n; k++){

                    if(map[targetNum][k]==1){
                        if(graphMap[k] > graphMap[targetNum]+1){
                            graphMap[k] = graphMap[targetNum]+1;
                            st.add(k);
                        }
                    }

                }
            }
            for(int k=0; k<n; k++){
                answerMap[i]+=graphMap[k];
            }
        }

        int smallNum=99999999;
        int answerIndex=0;

        for(int k=0; k<n; k++){
            if(smallNum > answerMap[k]){
                smallNum = answerMap[k];
                answerIndex =k;
            }
        }

        System.out.println(answerIndex+1);








    }


}
