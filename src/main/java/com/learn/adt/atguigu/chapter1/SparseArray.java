package com.learn.adt.atguigu.chapter1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class SparseArray {
    private static void readArr(File file, int[][] arr) {
        //try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split("\t");
                for (int i = 0; i < temp.length; i++) {
                    arr[row][i] = Integer.parseInt(temp[i]);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("Read data from file with error " + e);
        }
    }

    private static void write(File file, int[][] arr) {
        try (Writer out = new FileWriter(file)) {

            for (int[] row : arr) {
                for (int data : row) {
                    out.write(data + "\t");
                }
                out.write("\r\n");
            }

        } catch (IOException e) {
            System.out.println("write data into file with error " + e);
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {


        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\dddd.txt";
        write(new File(path), chessArr);

        int[][] arr = new int[11][11];
        readArr(new File(path), arr);
        System.out.println("从文件中读出的数组");
        displayArr(arr);

        System.out.println("原始的二维数组为");
        displayArr(chessArr);
        System.out.println("======================== \r\n \r\n");


        int[][] zipedArr = zipArray(chessArr);
        System.out.println("压缩后的数组为");
        displayArr(zipedArr);

        System.out.println("======================== \r\n \r\n");


        int[][] unzipedArr = unzipArray(zipedArr);
        System.out.println("还原后的数组");
        displayArr(unzipedArr);

        System.out.println(Arrays.equals(unzipedArr, chessArr));


    }

    private static void displayArr(int[][] arr) {
        for (int[] row : arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    private static int[][] zipArray(int[][] targetArr) {
        int row = targetArr.length;
        int column = targetArr[0].length;
        // 1 计算非零元素的个数
        int counter = 0;
        for (int[] temp : targetArr) {
            for (int data : temp) {
                if (data != 0) {
                    counter++;
                }
            }
        }

        // 2 存储非零元素的二维数组
        int[][] zipedArr = new int[counter + 1][3];

        zipedArr[0][0] = row;
        zipedArr[0][1] = column;
        zipedArr[0][2] = row * column;


        int k = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (targetArr[i][j] != 0) {

                    zipedArr[k][0] = i;
                    zipedArr[k][1] = j;
                    zipedArr[k][2] = targetArr[i][j];
                    k++;
                    //assert  k < counter;
                }
            }
        }

        return zipedArr;
    }

    private static int[][] unzipArray(int[][] targetArr) {
        int row = targetArr[0][0];
        int column = targetArr[0][1];
        int[][] unzipedArr = new int[row][column];
        int x, y = 0;
        for (int i = 1; i < targetArr.length; i++) {
            x = targetArr[i][0];
            y = targetArr[i][1];
            unzipedArr[x][y] = targetArr[i][2];
        }

        return unzipedArr;
    }
}
