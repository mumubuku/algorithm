package com.example.algorithm.number.provinces;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 *
 * @author mumu
 * @date 2024/4/30
 * @description TODO
 */
public class BFS {

    public static void main(String[] args) {
        JointSet jointSet = new JointSet();
        int[][] cities = new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
        jointSet.findCity(cities);
    }

    public Integer findCity(int[][] cities) {
        int[] visited = new int[cities.length];


        int total = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = 1;
                    for (int jj = 0; jj < visited.length; jj++) {
                        if (cities[j][jj] == 1 && visited[jj] != 1) {
                            queue.offer(i);
                        }
                    }
                }
                total = total + 1;
            }
        }


        return total;


    }
}
