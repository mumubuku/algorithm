package com.example.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 *
 * @author mumu
 * @date 2024/6/4
 * @description TODO
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List result = permutations.getPermutations("abc");
        System.out.println(result);
    }

    public List<String> getPermutations(String s){
        List<String> res = new ArrayList<>();
        backTracer(res,new StringBuilder(),s.toCharArray(),new int[s.length()]);

        return res;
    }

    public void backTracer(List<String> result ,StringBuilder sb ,char [] chars, int [] used){
        if(sb.length() == chars.length){
            result.add(sb.toString());
            return;
        }
        for(int i = 0 ; i < chars.length ; i++){
            if(used[i] == 1){
                continue;
            }
            sb.append(chars[i]);
            used[i] = 1;
            backTracer(result,sb,chars,used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = 0;
        }
    }
}
