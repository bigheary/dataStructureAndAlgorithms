package hihocoder.microsoft.d406;

import java.util.Scanner;

public class Main3 {
    
	public int getMinimumGridNum(char[][] grids, int n, int m){
		if (grids == null) {
			return -1;
		}
		
		int[][] down = new int[n][m];
		int[][] right = new int[n][m];
		//init
		right[0][0] = 0;
		if (grids[0][0] == 'b') {
			right[0][0] = 1;
		}
		if(m == 1 || grids[0][1] == 'b'){
			down[0][0] = right[0][0];
		}else {
			down[0][0] = right[0][0] + 1;
		}
		
		// 第一行
		for(int j = 1; j < m; j++){
			// to right
			if(grids[0][j] == 'b'){
				right[0][j] = right[0][j - 1] + 1;
			}else {
				right[0][j] = right[0][j - 1];
			}
			
			// to down
			if(j + 1 == m || grids[0][j + 1] == 'b'){
				down[0][j] = right[0][j];
			}else {
				down[0][j] = right[0][j] + 1;
			}
		}
		
		// 第一列
		for(int i = 1; i < n; i++){
			//to down
			if(grids[i][0] == 'b'){
				down[i][0] = down[i - 1][0] + 1;
			}else {
				down[i][0] = down[i - 1][0];
			}
			// to right
			if(i + 1 == n || grids[i + 1][0] == 'b'){
				right[i][0] = down[i][0];
			}else {
				right[i][0] = down[i][0] + 1;
			}
		}
		
		// 内点
		for (int i = 1; i < n; i++) {
			for(int j = 1; j < m; j++){
				//更新(i, j)位置的right, down 信息
				//从左边来的点
				//往右
				if(grids[i][j] == 'b'){
					right[i][j] = right[i][j - 1] + 1;
				}else {
					right[i][j] = right[i][j - 1];
				}
				//往下
				if (j + 1 == m || grids[i][j + 1] == 'b') {
					down[i][j] = right[i][j];
				}else {
					down[i][j] = right[i][j] + 1;
				}
				
				//从上边来的点
				int r, d;
				if (grids[i][j] == 'b') {
					d = down[i - 1][j] + 1;
				}else {
					d = down[i - 1][j];
				}
				
				if (i + 1 == n || grids[i + 1][j] == 'b') {
					r = d;
				}else {
					r = d + 1;
				}
				
				down[i][j] = down[i][j] < d ? down[i][j] : d;
				right[i][j] = right[i][j] < r ? right[i][j] : r;
			}
		}
		
		return down[n - 1][m - 1] < right[n - 1][m - 1] ? down[n - 1][m - 1] : right[n - 1][m - 1]; 
		
	}
		
		
		
		
		// init
		/*int[][] cost = new int[n][m];
		if (grids[0][0] == 'b') {
			cost[0][0] = 1;
		}else {
			cost[0][0] = 0;
		}
		// first row
		for(int j = 1; j < m; j++){
			if (grids[0][j] == 'b') {
				cost[0][j] = cost[0][j - 1] + 1;
			}else {
				cost[0][j] = cost[0][j - 1];
			}
		}
		// first colum
		for(int i = 1; i < n; i++){
			if (grids[i][0] == 'b') {
				cost[i][0] = cost[i - 1][0] + 1;
			}else {
				cost[i][0] = cost[i - 1][0];
			}
		}
		
		int end = m < n ? m : n;
		int tmpCost = 0;
		// then from left to right, and from top to bottom
		for(int i = 1; i < end; i++){
			tmpCost = cost[i][i - 1] < cost[i - 1][i] ? cost[i][i - 1] : cost[i - 1][i];
			if(grids[i][i] == 'b'){
				cost[i][i] = tmpCost + 1;
			}else{
				cost[i][i] = tmpCost;
			}
			
			// row
			for(int j = i + 1; j < m; j++){
				tmpCost = cost[i][j - 1] < cost[i - 1][j] ? cost[i][j - 1] : cost[i - 1][j];
				if (grids[i][j] == 'b') {
					cost[i][j] = tmpCost + 1;
				}else{
					cost[i][j] = tmpCost;
				}
			}
			// column
			for(int j = i + 1; j < n; j++){
				tmpCost = cost[j][i - 1] < cost[j - 1][i] ? cost[j][i - 1] : cost[j - 1][i];
				if (grids[i][j] == 'b') {
					cost[i][j] = tmpCost + 1;
				}else {
					cost[i][j] = tmpCost;
				}
			}
			
		}
		return cost[n - 1][m - 1];
		}*/
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n, m;
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		char[][] grids = new char[n][];
		for (int i = 0; i < n; i++) {
			grids[i] = in.nextLine().toCharArray();
		}
		
		System.out.print(new Main3().getMinimumGridNum(grids, n, m));
		
	}

}
