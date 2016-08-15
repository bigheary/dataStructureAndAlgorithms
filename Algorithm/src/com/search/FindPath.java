package com.search;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by xiexiaodong02 on 2016/8/14.
 */
public class FindPath {
    private static int min = 999;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int n, m;
    private static int x0, y0;
    private static int x1, y1;
    private static int[][] dt = new int[4][];
    private static boolean found = false;
    private static LinkedList<Node> stack = new LinkedList<Node>();
    static {
        dt[0] = new int[]{0, 1};
        dt[1] = new int[]{1, 0};
        dt[2] = new int[]{0, -1};
        dt[3] = new int[]{-1, 0};
    }
    /**
     * dfs
     * */
    public static void dfs(int x, int y, int step){
        if (x == x1 && y == y1){
            found = true;
            printStack(stack);
            return;
        }

        int nx, ny;
        for(int k = 0; k <= 3; k++){
            nx = x + dt[k][0];
            ny = y + dt[k][1];

            if (nx < 0 || nx > n-1 || ny < 0 || ny > m-1){
                continue;
            }

            if (found)
                return;

            if (arr[nx][ny] == 0 &&  visited[nx][ny] == false){
                stack.push(new Node(nx, ny));
                visited[nx][ny] = true;
                dfs(nx, ny, step+1);
                visited[nx][ny] = false;
                stack.pop();
            }
        }

        return;
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

    public static void main(String[] args){
        x1 = 3;
        y1 = 2;
        x0 = 0;
        y0 = 0;
        init();
        visited[0][0] = true;
        dfs(x0, y0, 0);
    }

    private static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void printStack(LinkedList<Node> stack){
        Iterator<Node> iterator = stack.iterator();
        while (iterator.hasNext()){
            Node tmp = iterator.next();
            System.out.print("("+tmp.x+", "+tmp.y+")   ");
        }
        System.out.println();
    }

}
