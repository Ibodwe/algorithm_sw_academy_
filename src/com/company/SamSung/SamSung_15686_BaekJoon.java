package com.company.SamSung;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class SamSung_15686_BaekJoon {

   static ArrayList<xandy> chicken = new ArrayList<xandy>();

   static ArrayList<xandy> house = new ArrayList<xandy>();
   static ArrayList<xandy> sample = new ArrayList<xandy>();

    static int chickenDistance = 999999;

  static public class xandy{
        int x;
        int y;
        public xandy(int a, int b){
            x =a ;
            y = b;
        }
    }

    static public void selectChicken(int m, int count, int index ){
        int value =0;
      if(count==m){
          //선택 완료

          for(int j=0; j< sample.size(); j++){
              System.out.print(sample.get(j).x +" " + sample.get(j).y);
              System.out.println();
          }
          System.out.println();




          for(int i=0; i<house.size(); i++){
              int temp = 999999;
              for(int j=0; j<sample.size(); j++){
                  int x = calDistance(house.get(i).x, house.get(i).y, sample.get(j).x, sample.get(j).y);
                  temp = Math.min(x,temp);
              }
              value += temp;
          }

          chickenDistance = Math.min(chickenDistance,value);

          return;
      }

      for(int i =index; i< chicken.size();i++ ){
            sample.add(chicken.get(i));
            selectChicken(m,count+1,i+1);
            sample.remove(chicken.get(i));
      }

    }

    static public int calDistance(int x1, int y1, int x2, int y2){
        int a = Math.abs(x1-x2);
        int b = Math.abs(y1-y2);
      return a+b;
    }



    public static void main(String args[] ){


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();




        int[][] map = new int [n][n];

        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                int num = sc.nextInt();

                if(num==1){
                    house.add(new xandy(i,j));
                }
                if(num==2){
                    chicken.add(new xandy(i,j));
                }
            }
        }

        selectChicken(m,0,0);
        System.out.println(chickenDistance);
    }
}
