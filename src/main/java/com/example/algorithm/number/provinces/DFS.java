package com.example.algorithm.number.provinces;

/**
 * DFS
 *
 * @author mumu
 * @date 2024/4/30
 * @description TODO
 */
public class DFS {

    public static void main(String[] args) {
        JointSet jointSet = new JointSet();
        int[][]cities = new int [][]{
                {1,1,0},{1,1,0},{0,0,1}
        };
        jointSet.findCity(cities);
    }

    public  Integer findCity(int [][] cities){

        int [] visited = new int[cities.length];


        int total = 0;
        for (int i = 1 ; i < visited.length ; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                dfs(cities,visited,i);
                total = total +1;
            }
        }
        System.out.println(total);
        return  total;
    }

    public void dfs(int [][] cities, int[] visited , int ll){

            for(int j = 0 ; j < cities.length; j++){
                if(cities[ll][j] == 1 && visited[j] != 1){
                    visited[j] = 1;
                    dfs(cities,visited,j);
                }
            }


    }

}
