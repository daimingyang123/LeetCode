package com.mingyangdai.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author daimingyang
 * @since 2018/9/28
 */
public class SumofDistancesinTree {
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] map = new int[N][N];
        
        for (int[] array : edges) {
            map[array[0]][array[1]] = 1;
            map[array[1]][array[0]] = 1;
        }
        
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                res[i] += bfs(i, j, map, new boolean[N]);
            }
        }
        return res;
    }
    
    private int bfs(int start, int target, int[][] map, boolean[] visited) {
        visited[start] = true;
        //start = 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < map[0].length; i++) {
            if (i != start && map[start][i] != 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            Queue<Integer> queue2 = new LinkedList<>();
            while (!queue.isEmpty()) {
                int i = queue.poll();//i = 1
                if (i == target) {
                    return map[start][i];
                }
                
                if (visited[i] == true) continue;
                visited[i] = true;
                
                //backward
                for (int j = 0; j < map.length; j++) {
                    if (j != i && map[j][start] != 0 && map[j][i] == 0) {
                        int dis = map[j][start] + map[start][i];
                        map[j][i] = dis;
                        map[i][j] = dis;
                    }
                }
                
                //forward
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] != 0 && !visited[j]) {
                        queue2.offer(j);
                    }
                }
            }
            queue = queue2;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int N = 6;
        int[][] edges = new int[][]{
                {0,1},{0,2},{2,3},{2,4},{2,5}
        };
        int[] res = new SumofDistancesinTree().sumOfDistancesInTree(N, edges);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
