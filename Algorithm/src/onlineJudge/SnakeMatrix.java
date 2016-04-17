package onlineJudge;


public class SnakeMatrix {
	
	public void getSnakeMatrix(int n){
		if(n < 0)
			return ;
		int cnt = 1;
		int[][] matrix = new int[n][n];
		for(int i = 0; i < (n+1)/2; i++){
			int delta = n - 2*i - 1;
			matrix[i][i] = cnt;
			for(int s = i; s < n - i - 1; s++){
				matrix[i][s] = cnt;
				matrix[s][n - i - 1] = cnt + delta;
				matrix[n - i - 1][n - s - 1] = cnt + 2*delta;
				matrix[n - s - 1][i] = cnt + 3*delta;
				cnt++;
			}
			cnt += 3*delta;
		}
		printMatrix(matrix, n, n);
		return ;
	}
	
	public void printMatrix(int[][] matrix, int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeMatrix sm = new SnakeMatrix();
		sm.getSnakeMatrix(1);
	}

}
