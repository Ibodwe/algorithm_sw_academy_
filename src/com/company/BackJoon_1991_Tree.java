
package com.company;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackJoon_1991_Tree  {




    static     Tree[] trmap;
    static  public void prior(int num){

        System.out.print(trmap[num].value);

        if(trmap[num].left != null){

            prior(trmap[num].left.value -'A');
        }

        if(trmap[num].right != null){
            prior(trmap[num].right.value -'A');
        }
    }

    static  public void post(int num){



        if(trmap[num].left != null){

            post(trmap[num].left.value -'A');
        }

        if(trmap[num].right != null){
            post(trmap[num].right.value -'A');
        }

        System.out.print(trmap[num].value);
    }

    static  public void middle(int num){



        if(trmap[num].left != null){

            middle(trmap[num].left.value -'A');
        }

        System.out.print(trmap[num].value);

        if(trmap[num].right != null){
            middle(trmap[num].right.value -'A');
        }
    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t= Integer.parseInt(st.nextToken());

        trmap = new Tree[t];

        //처음에는 abcd 순서대로 초기화가 필요하다.
        for (int i = 0; i < t; i++) {
            trmap[i] = new Tree((char) ('A' + i));
        }


        //트리 완성
        for(int i =0; i< t; i++){
            st = new StringTokenizer(br.readLine());
            char a =  st.nextToken().charAt(0);
            char b=  st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            trmap[a-'A'] = new Tree(a);

            if(b!='.')
                trmap[a-'A'].left = trmap[b-'A'];

            if(c!='.')
                trmap[a-'A'].right = trmap[c-'A'];
        }

        prior(0);
        System.out.println();
        middle(0);
        System.out.println();
        post(0);




    }

    static class Tree{
        char value ;
        Tree left;
        Tree right;

        public Tree(char value){
            this.value = value;

        }
    }


}







