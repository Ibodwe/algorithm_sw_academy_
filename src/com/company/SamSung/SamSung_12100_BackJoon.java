package com.company.SamSung;


import java.util.*;

public class SamSung_12100_BackJoon {

    static int[] an = new int [5];
    static int answer = 0;
    static int n;
    static int[][] map;
    //왼 오 상 하
    static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};

    public static void make(int count){

        if(count==5){
            int [][] temp2 = new int[n][n];

            for(int i =0; i<n; i++){
                for(int j =0; j<n;j++){
                    int value =  map[i][j];
                    temp2[i][j] = value;
                }
            }
            move(temp2);

            return;
        }

        for(int i =0; i<5; i++){
            an[count] = i;
            make(count+1);
        }
    }

    public static void move(int [][] temp){
        for(int i =0; i<5; i++){
            //왼 오 상 하
            int v = an[i];
            switch (v){
                case 0:
                    for(int j =0; j<n; j++){
                        for(int k=1; k<n; k++){
                            if(temp[j][k]!=0){
                                int value = temp[j][k];
                                int index = 1;
                                while(true){
                                    if( isValid(j,k-index) && temp[j][k-index] ==0){
                                        temp[j][k-index] = value;
                                        temp[j][k-index+1]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=1; k<n; k++){
                            if(temp[j][k-1] == temp[j][k]){
                                temp[j][k-1] = temp[j][k]*2;
                                temp[j][k] = 0;
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=1; k<n; k++){
                            if(temp[j][k]!=0){
                                int value = temp[j][k];
                                int index = 1;
                                while(true){
                                    if( isValid(j,k-index) && temp[j][k-index] ==0){
                                        temp[j][k-index] = value;
                                        temp[j][k-index+1]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

//                    for(int j =0; j<n; j++){
//                        for(int k=0; k<n; k++){
//                            System.out.print(temp[j][k]+" ");
//                        }
//                        System.out.println();
//                    }

                    break;

                case 1:

                    for(int j =0; j<n; j++){
                        for(int k=n-1; k>=0; k--){
                            if(temp[j][k]!=0){
                                int value = temp[j][k];
                                int index = 1;
                                while(true){
                                    if(isValid(j,k+index) && temp[j][k+index] ==0){
                                        temp[j][k+index] = value;
                                        temp[j][k+index-1]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=n-1; k>0; k--){
                            if(temp[j][k-1] == temp[j][k]){
                                temp[j][k] = temp[j][k-1]*2;
                                temp[j][k-1] = 0;
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=n-1; k>=0; k--){
                            if(temp[j][k]!=0){
                                int value = temp[j][k];
                                int index = 1;
                                while(true){
                                    if(isValid(j,k+index) && temp[j][k+index] ==0){
                                        temp[j][k+index] = value;
                                        temp[j][k+index-1]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    break;
                //위
                case 2:

                    for(int j =0; j<n; j++){
                        for(int k=1; k<n; k++){
                            if(temp[k][j]!=0){
                                int value = temp[k][j];
                                int index = 1;
                                while(true){
                                    if(isValid(j,k-index) && temp[k-index][j] ==0){
                                        temp[k-index][j] = value;
                                        temp[k-index+1][j]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=1; k<n; k++){
                            if(temp[k-1][j] == temp[k][j]){
                                temp[k-1][j] = temp[k][j]*2;
                                temp[k][j] = 0;
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=1; k<n; k++){
                            if(temp[k][j]!=0){
                                int value = temp[k][j];
                                int index = 1;
                                while(true){
                                    if(isValid(j,k-index) && temp[k-index][j] ==0){
                                        temp[k-index][j] = value;
                                        temp[k-index+1][j]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                //아래
                case 3:

                    for(int j =0; j<n; j++){
                        for(int k=n-1; k>=0; k--){
                            if(temp[k][j]!=0){
                                int value = temp[k][j];
                                int index = 1;
                                while(true){
                                    if(isValid(j,k+index) && temp[k+index][j] ==0){
                                        temp[k+index][j] = value;
                                        temp[k+index-1][j]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=n-1; k>0; k--){
                            if(temp[k-1][j] == temp[k][j]){
                                temp[k][j] = temp[k-1][j]*2;
                                temp[k-1][j] = 0;
                            }
                        }
                    }

                    for(int j =0; j<n; j++){
                        for(int k=n-1; k>=0; k--){
                            if(temp[k][j]!=0){
                                int value = temp[k][j];
                                int index = 1;
                                while(true){
                                    if(isValid(j,k+index) && temp[k+index][j] ==0){
                                        temp[k+index][j] = value;
                                        temp[k+index-1][j]=0;
                                        index++;
                                    }else{
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    break;

            }

//            System.out.println(an[i]);
//            for(int k =0; k<n; k++){
//                for(int j =0; j<n; j++){
//                    System.out.print(temp[k][j]+" ");
//                }
//                System.out.println();
//            }
        }

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                int num = temp[i][j];
                answer = Math.max(answer,num);
            }
        }
    }


    static public boolean isValid(int a, int b){
        if(a<0 || a>=n ||b<0 || b>=n){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // make(0);

        n = sc.nextInt();

        map = new int [n][n];

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        //왼 오 상 하
//        an[0]= 0;
//        an[1] = 3;
//        an[2] = 1;
//        an[3] = 2;
//        an[4] = 1;
//        move(map);
        make(0);

        System.out.println(answer);

    }


}







