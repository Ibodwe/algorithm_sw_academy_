    package com.company;


    import java.text.DecimalFormat;
    import java.util.*;


    public class Main {

        static boolean[][][] number;
        static ArrayList<ArrayList<Integer>> numMap = new ArrayList<>();
        static int numberIndex = -1;
        static int n ;
        static long answer=0;
        static int anscount=0;
        static boolean isAble = false;
       static public void checkNum(boolean [][] temp, int num ){
            numberIndex++;

//           for(int i =0; i<5; i++){
//               for(int j =0; j<3; j++){
//                   System.out.print(temp[i][j]+" ");
//               }
//               System.out.println();
//           }

            for(int i =0; i<10; i++){
                boolean isvalide = false;
                for(int j =0; j<5; j++){
                    for(int k=0; k<3; k++){
    //                if(temp[j][k]==true && number[i][j][k]==false){
    //                    isvalide=true;
    //                }

                    if(temp[j][k]==false && number[i][j][k]==true){
                        isvalide= true;
                    }

                    }

                }

                if(!isvalide){
                   // System.out.println(i);
                    numMap.get(numberIndex).add(i);
                }
            }
        }


        static void calAnswerNum(int currentCount, long totalValue){

           if(currentCount==n){
               answer+= totalValue;
               //System.out.println(totalValue);
               anscount++;
               return;
           }

           for(int i =0; i<numMap.get(currentCount).size(); i++){
               int selectNum = numMap.get(currentCount).get(i);
             //  System.out.println(selectNum);
               calAnswerNum(currentCount+1,totalValue*10+selectNum);
           }


        }


        public static void main(String[] args) {


            number = new boolean[10][5][3];

            number[0][1][1]=true;
            number[0][2][1] = true;
            number[0][3][1] = true;

            number[1][0][0] = true;
            number[1][0][1] = true;
            number[1][1][0] = true;
            number[1][1][1] = true;
            number[1][2][0] = true;
            number[1][2][1] = true;
            number[1][3][0] = true;
            number[1][3][1] = true;
            number[1][4][0] = true;
            number[1][4][1] = true;

            number[2][1][0] = true;
            number[2][1][1] = true;
            number[2][3][1] = true;
            number[2][3][2] = true;

            number[3][1][0] = true;
            number[3][1][1] = true;
            number[3][3][0] = true;
            number[3][3][1] = true;

            number[4][0][1] = true;
            number[4][1][1] = true;
            number[4][3][0] = true;
            number[4][3][1] = true;
            number[4][4][0] = true;
            number[4][4][1] = true;

            number[5][1][1] = true;
            number[5][1][2] = true;
            number[5][3][0] = true;
            number[5][3][1] = true;

            number[6][1][1] = true;
            number[6][1][2] = true;
            number[6][3][1] = true;

            number[7][1][0] = true;
            number[7][1][1] = true;
            number[7][2][0] = true;
            number[7][2][1] = true;
            number[7][3][0] = true;
            number[7][3][1] = true;
            number[7][4][0] = true;
            number[7][4][1] = true;

            number[8][1][1] = true;
            number[8][3][1] = true;

            number[9][1][1] = true;
            number[9][3][0] = true;
            number[9][3][1] = true;

            Scanner sc = new Scanner(System.in);

             n  = Integer.parseInt(sc.nextLine());

            int r = 5;
            int w = n*4-1;

            for(int i =0; i<n; i++){
                ArrayList<Integer>temp = new ArrayList<>();
                numMap.add(temp);
            }




            char [][] map = new char[r][w];

            for(int i =0; i<r; i ++){
                String temp = sc.nextLine();
                for(int j=0; j<w; j++){
                    map[i][j] = temp.charAt(j);
                }
            }


            int index = 3;
            boolean[][] tempMap = new boolean[5][3];

            for(int i=0; i < w; i++){
                int countNum = 15;

                for(int j =0; j < 5; j++){
                    int vv = i%4;
                    if(vv==3){
                        continue;
                    }
                    if(map[j][i] =='.'){
                        tempMap[j][vv] = true;
                        countNum--;
                    }else{
                        tempMap[j][vv] = false;
                    }
                }

                if(i == index-1){
                    // -> 0~9까지 비교
                    index += 4;
                    checkNum(tempMap,countNum);

                }

            }


            calAnswerNum(0,0);

            for(int i =0; i<n; i++){
                if(numMap.get(i).size()==0){
                    isAble=true;
                }
            }

            if(isAble){
                System.out.println(-1);
            }else{
                double aa = (double)answer/(double)anscount;

                DecimalFormat format = new DecimalFormat(".#####");
                String str = String.format("%.10f",aa);
                System.out.println(aa);

            }



        }






        }
