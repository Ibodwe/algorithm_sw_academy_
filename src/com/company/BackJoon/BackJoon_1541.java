package com.company.BackJoon;


import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BackJoon_1541 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        int index = 0 ;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();



        for(int i = index; i<sentence.length(); i++){
            if(sentence.charAt(i)=='-' || sentence.charAt(i)=='+'){
                int tempNum = Integer.parseInt(sentence.substring(index,i));
                numStack.add(tempNum);
                String tempSign = sentence.substring(i,i+1);
                charStack.add(tempSign);

//                    System.out.println(tempNum);
                //                  System.out.println(tempSign);
                index = i+1;
            }
        }
        int tempNum = Integer.parseInt(sentence.substring(index));
        numStack.add(tempNum);

        int answer = 0;
        int secondNum = 0;
        while (!charStack.isEmpty()){
            String firstSign = charStack.peek();
            charStack.pop();

            secondNum = numStack.peek();
            numStack.pop();

            if(firstSign.equals("+")){
                int thridNum = numStack.peek();
                numStack.pop();
                numStack.add(secondNum+thridNum);
            }else{
                answer-=secondNum;
            }

        }

        int xx =numStack.peek();
        System.out.println(answer+xx);

    }
}

