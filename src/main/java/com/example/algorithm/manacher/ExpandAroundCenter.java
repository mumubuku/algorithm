package com.example.algorithm.manacher;

/**
 * ExpandAroundCenter
 *
 * @author mumu
 * @date 2024/5/10
 * @description TODO
 */
public class ExpandAroundCenter {


    public static void main(String[] args) {
        ExpandAroundCenter expandAroundCenter = new ExpandAroundCenter();
        Integer count = expandAroundCenter.numberofSubPalindrome("aaa");
        System.out.println(count);

    }



    public Integer numberofSubPalindrome(String s){
        Integer length = s.length();
        Integer count = 2*length -1;
        int total = 0;
        for(int i = 0 ; i <= count ; i++){
            Integer left = i/2 ;
            Integer right = i/2 + i%2;

            while (left>=0 && right< length && s.charAt(left) == s.charAt(right) ){
                left--;
                right++;
                total++;
            }
        }
        return  total;
    }

}
