package com.example.algorithm.high.score;

import java.util.HashMap;

/**
 * Soultion
 *
 * @author mumu
 * @date 2024/5/29
 * @description TODO
 */
public class Soultion {


    public static void main(String[] args) {
        Soultion soultion = new Soultion();
        int [] array = {25,27,27,21,39,30,38,17,36,23,23,2,34,39,11,36,15,29,35,36,39,3,30,29,33,0,33,21,41,21,36,36,35,35,19,36,42,19,28,11,44,11,30,6,11};
        int result = soultion.edgeScore(array);
        System.out.println(result);
    }

    public int edgeScore(int[] edges) {
        HashMap<Integer,Long> score = new HashMap();
        long maxValue = 0L;
        int result = -1;

        for(int i = 0 ; i < edges.length ; i++){
            Long value = score.getOrDefault(edges[i], 0L);
            value += i;
            if(value > maxValue){
                result = edges[i];
            } else if( value.equals(maxValue) ){
                result = Math.min(result, edges[i]);
            }
            maxValue = Math.max(value,maxValue);

            score.put(edges[i],value);
        }
        return result;
    }
}
