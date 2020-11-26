package com.company;




public class Main2 {


    static public long calMax(int i, long n, int[][] products ) {

        int stock = products[i][0];
        int cost = products[i][1];
        int num  = products[i][2];

        if (stock <= 0) {
            return 0;
        }
        if (stock >= num ) {

            return cost * num ;
        }
        return stock * cost;
    }

    static public long calValue(int i, long n, int[][] products ) {

        int stock = products[i][0];
        int cost = products[i][1];
        int num  = products[i][2];

        if (stock <= 0) {
            return 0;
        }

        if (stock >= num * n) {
            products[i][0] -= num*n;
            return num * cost * n;
        }
        products[i][0] = 0;

        return stock * cost;
    }


    public static void main(String[] args) {

        long n = 3;
        int[][] products = {{6, 5, 1}, {11, 3, 2},{7,10,3}};

        // 며칠 동안 최대로 되는지 찾고 나머지는 그냥 값을 더해 주 면 됨..!
        long answer = 0;
        //가민히 나두면 얼마나 팔리는 지 먼저 check
        for(int i =0; i<products.length; i++){
            answer += calValue(i,n,products);
        }

        for(int i =0; i< n; i++){

            int storeProductIndex = 0;
            long storeProductValue = 0;

            for(int j=0; j<products.length; j++){
                long temp = calMax(j,n,products);

                if(storeProductValue < temp) {
                    storeProductIndex = j;
                    storeProductValue = temp;
                }
            }
            answer += storeProductValue;

            products[storeProductIndex][0] -= (storeProductValue/products[storeProductIndex][1]);
        }

        System.out.println(answer);



    }


}






