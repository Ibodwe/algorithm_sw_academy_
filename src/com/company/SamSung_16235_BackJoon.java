package com.company;



import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.concurrent.CompletionException;

/*
 *
 * */
public class SamSung_16235_BackJoon {

    static int n;

    public static boolean check(int a, int b ){

        if(a<0 || a >=n || b<0 || b >= n){
            return false;
        }

        return true;
    }




    public static void main(String[] args) {
        // write your code here

        //입력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] treeMap = new int [n][n];
        int[][] A = new int [n][n];
        int[][] newTree = {{-1,-1},{-1,0},{-1,+1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        //2차원 배열 arrayList 초기화!!
        //공간 복잡도 체크 주의
        ArrayList<ArrayList<ArrayList<Integer>>> tree = new ArrayList<ArrayList<ArrayList<Integer>>>();

        for(int i =0; i<n ; i++){
            for(int j=0; j<n; j++){
                treeMap[i][j] = 5;
            }
        }

        for(int i =0; i<n ; i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
            tree.add(temp);
            for(int j=0; j<n; j++){
                ArrayList<Integer> temp2 = new ArrayList<Integer>();
                tree.get(i).add(temp2);
            }
        }


        for(int i =0; i<n ; i++){
            for(int j=0; j<n; j++){
                A[i][j] = sc.nextInt();
            }
        }
        //나무의 나이를 어떻게 하지..?

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            x -=1;
            y -=1;
            int treeAge= sc.nextInt();
            tree.get(x).get(y).add(treeAge);
            Collections.sort(tree.get(x).get(y));
        }

        for(int i =0; i<k; i++){
            //i년차 봄 and 여름
            for(int j =0; j<n; j++){
                for(int a=0; a<n; a++){
                    if(tree.get(j).get(a).size()!=0){
                        //양분이 나이의 양보다 충분하다면..! 뺀다.
                        ArrayList<Integer> temp = tree.get(j).get(a);

                        for(int b=0; b < temp.size(); b++){
                            if(treeMap[j][a] >= temp.get(b)){
                                int value = temp.get(b);
                                tree.get(j).get(a).set(b,value+1);
                                treeMap[j][a] -= value;
                            }else{
                                //나무가 양분을 못 먹는 경우
                                int value =temp.get(b);
                                treeMap[j][a]+= value/2;
                                tree.get(j).get(a).remove(b);
                            }
                        }
                        //다시 정렬

                    }
                }
            }
            //겨울 번식 -->

            for(int j =0; j<n; j++){
                for(int a=0; a<n; a++){
                    if(tree.get(j).get(a).size()!=0){
                        //양분이 나이의 양보다 충분하다면..! 뺀다.
                        ArrayList<Integer> temp = tree.get(j).get(a);

                        for(int c = 0; c< temp.size(); c++){
                            int value = tree.get(j).get(a).get(c);

                            if(value%5==0){
                                //번식
                                for(int start = 0; start<8; start++){
                                    int x = j + newTree[start][0];
                                    int y = a + newTree[start][1];

                                    if(check(x,y)){
                                        tree.get(x).get(y).add(1);
                                        Collections.sort(tree.get(x).get(y));
                                    }
                                }
                            }
                        }


                    }
                }
            }

            //양분 추가.
            for(int j =0; j<n; j++){
                for(int a=0; a<n; a++){
                    treeMap[j][a] += A[j][a];
                }
            }

        }
        //나무의 수 출력..!
        int answer = 0;

        for(int j =0; j<n; j++){
            for(int a=0; a<n; a++){
                answer += tree.get(j).get(a).size();
            }
        }

        System.out.println(answer);

    }
}
