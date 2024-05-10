package com.example.algorithm.kmp;

/**
 * kmp
 *
 * @author mumu
 * @date 2024/5/10
 * @description TODO
 */
public class kmp {

    public static void main(String[] args) {
        kmp kmp = new kmp();
        Integer result =   kmp.findSub("aaaa","a");
        System.out.println(result);

    }

    public int [] buildPartArray(String pattern){
        int length = pattern.length();
        int [] result = new int[length];
        result[0] = 0;
        int i = 1;
        int j = 0;  // 理解成len;
        for(i = 1 ; i < length ; i++){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                result[i] = j;
                i++;
            } else {
                if(j != 0){
                    j = result[ j - 1];
                } else {
                    result [i] = 0;
                    i++;
                }
            }
        }
        return  result;
    }

    public Integer findSub(String main, String pattern){
        int [] pmt = buildPartArray(pattern);
        int i = 0;
        int j = 0;
        int mainLength = main.length();
        int patternLength = pattern.length();

        while (i < patternLength){
            if(main.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == patternLength){
                return i - j;
            } else if(i < mainLength && main.charAt(i) != pattern.charAt(j)){
                // 比较到不一致的时候，子串进行一定的回滚。
                if(j != 0){
                    j = pmt[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return  -1;


    }


}
