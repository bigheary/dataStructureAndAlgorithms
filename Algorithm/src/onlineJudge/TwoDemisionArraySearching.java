package onlineJudge;

public class TwoDemisionArraySearching {
	
	private int value;
	
	TwoDemisionArraySearching(int value){
		this.value = value;
	}
	
	//在行上找最大的小于等于
	public int findMaxLessEqual(int[][] a, int si, int sj, int ej){
			int mid = 0;
			//在行上二分
			int start = sj;
			int end = ej;
			while(start < end - 1){
				mid = (start + end) / 2;
				if(a[si][mid] > value){
					end = mid - 1;
				}else {
					start = mid;
				}
			}
			if (a[si][end] <= value) {
				return end;
			}else {
				return start;
			}
}
	
	//在列上找最小的大于等于
	public int findLessGreatEqual(int[][] a, int sj, int si, int ei){
			int mid = 0;
			//在列上二分
			int start = si;
			int end = ei;
			while(start < end){
				mid = (start + end) / 2;
				if(a[mid][sj] < value){
					start = mid + 1;
				}else {
					end = mid;
				}
			}
			return end;
	}
	
	public boolean matrixSearching(int[][] a, int n, int m){
		int si = 0, ei = 0;
		int sj = 0, ej = m - 1;
		while(si < n && sj < m){
			sj = findMaxLessEqual(a, si, sj, ej);
			if(a[si][sj] == value)
				return true;
			ei = n - 1;
			si++;
			
			si = findLessGreatEqual(a, sj, si, ei);
			if(a[si][sj] == value)
				return true;
			ej = sj - 1;
			sj = 0;
		}
		return false;
	}
	
	public boolean searchFromRightMost(int[][] a, int n, int m){
		int i = 0;
		int j = m - 1;
		while(i < n && j > -1){
			if(a[i][j] == m) return true;
			if (a[i][j] > m) {
				if(j == 0)
					return false;
				j--;
			}else {
				if(i == n-1)
					return false;
				i++;
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3,5,6},{4,5,7,8,10},{6,8,9,12,15},{7,11,14,17,18},{8,12,16,18,20}};
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++)
				System.out.print(a[i][j] + "\t");
			System.out.println();
		}
		
		TwoDemisionArraySearching tdas = new TwoDemisionArraySearching(16);
		//伪代码  
		long startTime=System.nanoTime();   //获取开始时间    
		System.out.println(tdas.matrixSearching(a, 5, 5));
		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");  
		
		
		startTime=System.nanoTime();   //获取开始时间
		System.out.println(tdas.searchFromRightMost(a, 5, 5));
		endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
	}

}
