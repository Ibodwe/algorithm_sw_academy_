package com.company.AlgoSpot;

import javax.swing.plaf.synth.SynthUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algospot_boogle {

    //dfs로 풀면 안되나..?

    static char[][] map = new char[5][5];
    static int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, -1}, {-1, 1}};
    static boolean isFind = false;
    static boolean[][][] visitied = new boolean[5][5][10];

    static public boolean checkWord(int i, int j, int index, String word) {

        visitied[i][j][index] = true;

        if(map[i][j]!= word.charAt(index)){
            return false;
        }


        if (index == word.length()-1) {
            return true;
        }


        for (int a = 0; a < direct.length; a++) {
            int nx = i + direct[a][0];
            int ny = j + direct[a][1];

            if (isInside(nx, ny)) {

                if(visitied[nx][ny][index+1]) {
                    continue;
                }

                if(checkWord(nx, ny, index + 1, word)){

                    return true;
                }
            }
        }
        return false;
    }

    static boolean isInside(int i, int j) {
        if (i < 5 && i >= 0 && j < 5 && j >= 0) {
            return true;
        }
        return false;
    }
    static void clean(){
        visitied = new boolean[5][5][10];
    }



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int index = 0; index < n; index++) {


            for (int i = 0; i < 5; i++) {
                String temp = br.readLine();
                for (int j = 0; j < 5; j++) {
                    map[i][j] = temp.charAt(j);
                }
            }

            int wordsNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < wordsNum; i++) {

                clean();
                String targetWord = br.readLine();

                isFind = false;

                for (int a = 0; a < 5; a++) {
                    for (int b = 0; b < 5; b++) {

                           isFind= checkWord(a, b, 0, targetWord);

                        if (isFind) {
                            break;
                        }

                    }
                    if (isFind) {
                        break;
                    }
                }

                if(isFind){
                    System.out.println(targetWord +" " + "YES");
                }else{
                    System.out.println(targetWord +" " + "NO");
                }

                }


            }


        }
    }
