package com.company;


import java.lang.reflect.Array;
import java.util.*;

public class Main {

    // 남은 숫자로 만들 수 있는 가장 근접한 페이지
    // 앞 자리 부터 가장 근접한 숫자로 만들어가자
    // 전체 숫자에서 빼기

    static class Student{
        int age;
        String name;

        public Student(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {

        int [] test = {1,2,3};
        int [] test2 = Arrays.copyOf(test , 6);

        List<Integer> t = Arrays.asList(new Integer(10));
        System.out.println(t.size());

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(3);
        ll.add(7);
        ArrayList<Integer> bv = new ArrayList<>();
        bv.add(3,5);
        bv.get(2);

        for(int i =0; i<test2.length; i++){
            System.out.println(test2[i]);
        }

        System.out.println(test2.length);

        Stack<Integer> st = new Stack<>();

        Queue<Integer> q = new LinkedList<>();

        PriorityQueue<Integer> h = new PriorityQueue<Integer>();
    }


}



