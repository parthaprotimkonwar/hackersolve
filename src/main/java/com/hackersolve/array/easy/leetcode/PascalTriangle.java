package com.hackersolve.array.easy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //generate pascal triangle
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentList = new ArrayList<Integer>();
            if (i == 0) {   //base case 0
                currentList.add(1);
            } else if (i == 1) {    //base case 1
                currentList.add(1);
                currentList.add(1);
            } else {            //generic case
                List<Integer> previousList = pascalTriangle.get(i - 1);
                for (int j = 0; j <= i; j++) {
                    //adding 1 for the edges
                    if (j == 0 || j == i) {
                        currentList.add(1);
                    } else {
                        //adding the two adjacent numbers for the new sum
                        int sum = previousList.get(j) + previousList.get(j - 1);
                        currentList.add(sum);
                    }
                }
            }
            pascalTriangle.add(currentList);
        }
        return pascalTriangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
