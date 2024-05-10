package com.example.algorithm.manacher;

/**
 * Manacher
 *
 * @author mumu
 * @date 2024/5/10
 * @description TODO
 */
public class ManacherPalindromeSubstringCount {


    public static void main(String[] args) {
        ManacherPalindromeSubstringCount manacherPalindromeSubstringCount = new ManacherPalindromeSubstringCount();
        Integer total = manacherPalindromeSubstringCount.countSubString("aaa");
        System.out.println(total);
    }

    public Integer countSubString (String s){
        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for(int i = 0 ; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("!");
        int center = 0;
        int right = 0;
        int length = sb.length();
        int []  p = new  int[length];
        int total = 0;

        for(int i = 1 ; i < length - 1 ; i++){
            int mirr = center*2 -i;

            // 注意增加这个判断，判断是否超过了最右边的蘑菇（b站）边界，超过取最小；
            if(i < right){
                p[i] = Math.min(p[mirr], right - i);
            }
            // 判断2段的边缘是否一样，如果一样继续扩展；
            while (sb.charAt(p[i] +i+ 1) == sb.charAt(i- p[i] - 1)){
                p[i]++;
            }
            // 如果超过了边界，更新右边界。
            if(i+p[i] > right){
                center = i;
                right = i+ p[i];
            }
            total +=  (p[i]+1)/2;

        }
        return  total;
    }

}
