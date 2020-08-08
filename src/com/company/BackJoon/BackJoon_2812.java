package com.company.BackJoon;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon_2812   {

    static int maxNum = 0;
    static int maxNumIndex =0;

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int canCount;
    static String number;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = br.readLine();

        Stack<Integer> stack = new Stack<>();

        //선택 할 수 있는 개수
        canCount = N-M;

        for(int i =0; i<N; i++){

            int num = number.charAt(i)-48;
            if(stack.isEmpty()){

            }else {
                while (!stack.isEmpty() && M >0 ) {
                    if (num > stack.peek()) {
                        M--;
                        stack.pop();
                    } else{
                        break;
                    }
                }
            }
            stack.push(num);
        }

        while (stack.size() > N-M){
            stack.pop();
        }

        while (!stack.isEmpty()){
            sb.append(stack.peek());
            stack.pop();
        }



        sb.reverse();

        System.out.println(sb);








    }
}
