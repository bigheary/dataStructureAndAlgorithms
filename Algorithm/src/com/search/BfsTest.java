package com.search;

import java.util.LinkedList;

/**
 * Created by xiexiaodong02 on 2016/8/14.
 */
public class BfsTest {
    private static int[][] arr;
    private static boolean[][] visited;
    private static int n, m;
    private static int x0, y0;
    private static int x1, y1;
    private static int[][] dt = new int[4][];
    static {
        dt[0] = new int[]{0, 1};
        dt[1] = new int[]{1, 0};
        dt[2] = new int[]{0, -1};
        dt[3] = new int[]{-1, 0};
    }

    public static void init(){
        arr = new int[5][];
        arr[0] = new int[]{0, 0, 1, 0};
        arr[1] = new int[]{0, 0, 0, 0};
        arr[2] = new int[]{0, 0, 1, 0};
        arr[3] = new int[]{0, 1, 0, 0};
        arr[4] = new int[]{0, 0, 0, 1};

        visited = new boolean[5][4];

        if (arr != null){
            n = arr.length;
            m = arr[0].length;
        }
    }

    static class Node{
        int x;//横坐标
        int y;//纵坐标
        int step;//步数
        Node(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static int bfsSearch(Node startNode){
        if (startNode.x == x1 && startNode.y == y1)
            return startNode.step;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(startNode);
        int nx, ny;
        boolean found = false;
        while(!queue.isEmpty()){
            Node head = queue.poll();
            for (int k = 0; k < 4; k++){
                nx = head.x + dt[k][0];
                ny = head.y + dt[k][1];
                if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1){
                    continue;
                }
                if (arr[nx][ny] == 0 && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    Node node = new Node(nx, ny, head.step+1);
                    queue.offer(node);
                }
                if (nx == x1 && ny == y1){
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        Node node= queue.peekLast();
        return node.step;
    }

    public static void main(String[] args){
        x0 = 0;
        y0 = 0;
        x1 = 2;
        y1 = 3;
        init();
        Node node = new Node(x0, y0, 0);
        int step = bfsSearch(node);
        System.out.println();
    }

}
