package com.company.BackJoon;


import java.util.Scanner;
import java.util.Stack;

public class BackJoon_9734 {


    /*
    *   순환소수는 9 일반 소수는 0 으로 치환 하여서 분모로 만든 후 계산
    *
    *
    * */

    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){


            String test = sc.nextLine();

            // 끝 부터 읽어서 분모를 만들어 내고
            // stack 2개 선언 ()스택, 전체 숫자 담는 stack

            Stack<Integer> fullNumberSt = new Stack<>();
            Stack<Integer> circulateNumberSt = new Stack<>();
            boolean isCirculNum = false;

            long denominator = 0;
            long molecule = 0;
            long temp = 0;
            int index = -1;

            //.을 기준으로 나누어서 데이터 전처리 필요
            for(int i = test.length()-1; i>=0; i--){

                char ch = test.charAt(i);

                if(ch==')'){
                    isCirculNum = true;
                    continue;
                }else if (ch== '('){
                    isCirculNum = false;
                    continue;
                }else if (ch==('.')){
                    index = i;
                    break;
                }
                //분모 만들기
                if(isCirculNum){
                    denominator = denominator*10+9;
                }else{
                    circulateNumberSt.add(ch-48);
                    denominator = denominator*10;
                }
                fullNumberSt.add(ch-48);
            }

            molecule = Integer.parseInt(test.substring(0,index));
            molecule*=10;
            temp = molecule;

            while(!fullNumberSt.isEmpty()){
                molecule += fullNumberSt.pop();
                molecule *=10;
            }

            while (!circulateNumberSt.isEmpty()){
                temp += circulateNumberSt.pop();
                temp *=10;
            }
            molecule /= 10;
            temp /= 10;

            molecule -= temp;
            long div = 2;



            while(molecule > div || denominator > div ){

                if(molecule % div==0 && denominator % div==0){
                    molecule/=div;
                    denominator/= div;
                }else{
                    div++;
                }

            }

            System.out.println(test+" = " + molecule +" / " + denominator);
            // System.out.println(molecule);
            //  System.out.println(denominator);

        }

    }


}
