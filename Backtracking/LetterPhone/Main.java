package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        System.out.println(m.letterCombinations("10"));

    }

    public ArrayList<String> letterCombinations(String a) {
        ArrayList<String> combinations = new ArrayList<>();

        HashMap<Character, String> numToStr = new HashMap<>();
        numToStr.put('0', "0");
        numToStr.put('1', "1");
        numToStr.put('2', "abc");
        numToStr.put('3', "def");
        numToStr.put('4', "ghi");
        numToStr.put('5', "jkl");
        numToStr.put('6', "mno");
        numToStr.put('7', "pqrs");
        numToStr.put('8', "tuv");
        numToStr.put('9', "wxyz");


        letterCombHelper(a, 0, new StringBuilder(), combinations, numToStr);

        return combinations;
    }

    public void letterCombHelper(String numString, int strIdx, StringBuilder temp, ArrayList<String> combinations, HashMap<Character,String> numToStr) {

        if(strIdx == numString.length()){
            combinations.add(temp.toString());
        } else {
            Character curChar = numString.charAt(strIdx);
            String numStr = numToStr.get(curChar);
            for(int i = 0; i < numStr.length(); i++){
                temp.append(numStr.charAt(i));

                letterCombHelper(numString, strIdx + 1, temp, combinations, numToStr);

                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
