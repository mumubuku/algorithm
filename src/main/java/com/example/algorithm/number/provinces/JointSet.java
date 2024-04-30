package com.example.algorithm.number.provinces;

/**
 * JointSet
 * @desc https://leetcode.cn/problems/number-of-provinces/description/ 对应的并查集的解法
 * @author mumu
 * @date 2024/4/30
 * @description TODO
 */
public class JointSet {

    public static void main(String[] args) {
        JointSet jointSet = new JointSet();
        int[][]cities = new int [][]{
            {0,1,1},{0,1,1},{0,1,1}
        };
        jointSet.findCity(cities);
    }

    public  Integer findCity(int [][] cities){

        int [] parent = new int[cities.length];

        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
        }

        for (int i = 0 ; i < parent.length ; i++){
            for (int j = i +1 ; j < parent.length ; j++){
                if(cities[i][j] == 1){
                    union(parent,i,j);
                }

            }
        }
        int total = 0;
        for (int i = 0 ; i < parent.length; i++){
            if(parent[i] == i){
                total = total +1;
            }
        }
         System.out.println(total);
        return  total;
    }


    public void union(int [] parent,int index1 , int index2){
        parent[findParent(parent,index1)] = findParent(parent,index2);
    }

    /**
     * @desc 经过路径优化的并查集的方法
     * @param parent
     * @param index
     * @return
     */

    public Integer findParent(int [] parent, int index){
        if(parent[index] != index){
            parent[index] =  findParent(parent,parent[index]);

        }
        return index;

    }
}
