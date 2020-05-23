package com.company.SamSung;

import java.util.Scanner;

public class SamSung_Swacademy_4013 {

    //시계 방향
   static public  void move(int [][]map, int number, int dir){

       if(dir==1){
           int temp = map[number][7];

           for(int i =7; i>0; i--){
               map[number][i] = map[number][i-1];
           }
           map[number][0] = temp;
       }else{
           int temp = map[number][0];

           for(int i=1; i<=7; i++){
               map[number][i-1] = map[number][i];
           }
           map[number][7] = temp;
       }

    }

    static public int change(int dir){
       if(dir==1){
           return 0;
       }else{
        return 1;
       }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int n =1; n<=T; n++){
            int answer = 0;
            int K = sc.nextInt();

            int [][] map = new int [5][8];

            //init 톱니
            for(int i =1; i<5; i++){
                for(int j=0; j<8; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i =0; i<K; i++){
                int number = sc.nextInt();
                int dir = sc.nextInt();
                boolean[] ch = new boolean[3];
                //check 모두 톱니가 다른지 검사
                if(map[1][2] != map[2][6]){
                    ch[0] = true;
                }

                if(map[2][2]!=map[3][6]){
                    ch[1] = true;
                }

                if(map[3][2]!=map[4][6]){
                    ch[2] = true;
                }

                switch (number){
                    case 1:
                        move(map,1,dir);
                        if(ch[0]){
                            move(map,2,change(dir));
                            if(ch[1]){
                                move(map,3,dir);
                                if(ch[2]){
                                    move(map,4,change(dir));
                                }
                            }
                        }
                        break;
                    case 2:
                        move(map,2,dir);

                        if(ch[0]){
                            move(map,1,change(dir));
                        }

                        if(ch[1]){
                            move(map,3,change(dir));
                            if(ch[2]){
                                move(map,4,dir);
                            }
                        }
                        break;
                    case 3:
                        move(map,3,dir);
                        if(ch[1]){
                            move(map,2,change(dir));
                            if(ch[0]){
                                move(map,1,dir);
                            }
                        }
                        if(ch[2]){
                            move(map,4,change(dir));
                        }
                        break;
                    case 4:
                        move(map,4,dir);
                        if(ch[2]){
                            move(map,3,change(dir));
                            if(ch[1]){
                                move(map,2,dir);
                                if(ch[0]){
                                    move(map,1,change(dir));
                                }
                            }
                        }
                        break;

                }

//                System.out.println("map");
//                for(int ii =1; ii<5; ii++){
//                    for(int j =0; j<8; j++){
//                        System.out.print(map[ii][j]+" ");
//                    }
//                    System.out.println();
//                }

            }




            for(int i =1; i<=4; i++){
                if(map[i][0]==1){
                    answer+= Math.pow(2,i-1);

                }
            }

            System.out.println("#"+n +" " +answer);





        }

    }
}
