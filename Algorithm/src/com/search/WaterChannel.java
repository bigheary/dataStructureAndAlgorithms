package com.search;

/**
 * Created by xiexiaodong02 on 2016/8/14.
 */
public class WaterChannel {
    private static int[][] arr;
    private static boolean[][] visited;
    private static int n, m;
    private static int x0, y0;
    private static int x1, y1;
    private static int[][] dt = new int[4][];
    private static boolean found = false;
    static {
        dt[0] = new int[]{0, 1};
        dt[1] = new int[]{1, 0};
        dt[2] = new int[]{0, -1};
        dt[3] = new int[]{-1, 0};
    }

    public static void init(){
        arr = new int[5][];
        arr[0] = new int[]{5, 3, 5, 3};
        arr[1] = new int[]{1, 5, 3, 0};
        arr[2] = new int[]{2, 3, 5, 1};
        arr[3] = new int[]{6, 1, 1, 5};
        arr[4] = new int[]{1, 5, 5, 4};

        visited = new boolean[5][4];

        if (arr != null){
            n = arr.length;
            m = arr[0].length;
        }
    }

    public static void dfs(int x, int y, int front){
        if (x == n-1 && y == m){
            found = true;
            return;
        }

        if (x < 0 || x > n-1 || y < 0 || y > m-1)
            return;

        if (visited[x][y])
            return;
        visited[x][y] = true;

        if (arr[x][y] == 5 || arr[x][y] == 6){
            if (front == 1){
                dfs(x, y+1, 1);
            }else if (front == 2){
                dfs(x+1, y, 2);
            }else if (front == 3){
                dfs(x, y-1, 3);
            }else {
                dfs(x-1, y, 4);
            }
        }

        if (arr[x][y] >= 1 && arr[x][y] <= 4){
            if (front == 1){
                dfs(x+1, y, 2);
                dfs(x-1, y, 4);
            }else if (front == 2){
                dfs(x, y+1, 1);
                dfs(x, y-1, 3);
            }else if (front == 3){
                dfs(x-1, y, 4);
                dfs(x+1, y, 2);
            }else {
                dfs(x, y+1, 1);
                dfs(x, y-1, 3);
            }
        }

        visited[x][y] = false;
        return;
    }

    public static void main(String[] args){
        x0 = 0;
        y0 = 0;
        init();
        dfs(x0, y0, 1);
        if (found)
            System.out.println("found");
    }

}
