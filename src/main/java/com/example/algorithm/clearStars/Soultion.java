package com.example.algorithm.clearStars;


import java.util.ArrayList;
import java.util.List;

/**
 * Soultion
 *
 * @author mumu
 * @date 2024/6/4
 * @description TODO
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.clearStars("dk**");
        System.out.println(result);



    }

    public String clearStars(String s) {
        List<List<Integer>> list = new ArrayList();
        for(int i = 0 ; i < 26 ; i++){
            List <Integer> subList = new ArrayList();
            list.add(subList) ;
        }

        char [] charArray = s.toCharArray();

        List<Integer> records = new ArrayList();

        String result = s;
        int deleteTotal = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(charArray[i] != '*'){
                int index = charArray[i] - 'a';
                list.get(index).add(i);
            } else {
                for(List<Integer> subList :list){
                    if(!subList.isEmpty()){
                        records.add(subList.get(subList.size() - 1));
                        subList.remove(subList.get(subList.size() - 1));

                        break;
                    }
                }
                records.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = records.size() - 1 ; i > 0 ; i--){
            result = removeCharAtIndex(result,records.get(i));

        }
        return result;



    }

    public String removeCharAtIndex(String s, int index) {
        if (index < 0 || index >= s.length()) {
            return s; // 索引越界，返回原字符串
        }

        return s.substring(0, index) + s.substring(index + 1);
    }


}
