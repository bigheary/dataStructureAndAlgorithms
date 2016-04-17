package beautyOfProgramming;

public class BinarySearch {
	
	// 输出等于m的最左边的下标,如果m不在a中，则输出大于m的第一个下标
	public int leftMostEqual(int[] a, int m){
		int start = 0;
		int end = a.length - 1;
		int mid;
		while(start < end){
			mid = start + (end - start) / 2;
			if (a[mid] < m) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return end;
	}
	// 输出等于m的最右边的下标,如果m不在a中，则输出小于m的最后一个下标
	public int rightMostEqual(int[] a, int m){
		int start = 0;
		int end = a.length - 1;
		int mid;
		while(start < end - 1){
			mid = start + (end - start) / 2;
			if (a[mid] > m) {
				end = mid - 1;
			}else {
				start = mid;
			}
		}
		if(a[end] == m)
			return end;
		else {
			return start;
		}
	}
	
	// 大于等于给定数的最小的 与 leftMostEqual
	public int leftMostGreatEqual(int[] a, int m){
		int start = 0;
		int end = a.length - 1;
		int mid;
		while(start < end){
			mid = start + (end - start)/2;
			if (a[mid] < m) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return end;
	}
/*	public int rightMostGreatEqual(int[] a, int m){
		int start = 0;
		int end = m - 1;
		int mid;
		while(start < end){
			mid = start + (end - start)/2;
			if (a[mid] < m) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return end;
	}*/
	
	/*public int leftMostLessEqual(int[] a, int m){
		int start = 0;
		int end = m - 1;
		int mid;
		while(start < end - 1){
			mid = start + (end - start)/2;
			if(a[mid] > m)
				end = mid - 1;
			else {
				start = mid;
			}
		}
		if (a[start] < m) {
			return start;
		}else {
			return end;
		}
	}*/
	
	//小于等于给定值的最右边的下标  和 rightMostEqual一样？
	public int rightMostLessEqual(int[] a, int m){
		int start = 0;
		int end = a.length - 1;
		int mid;
		while(start < end - 1){
			mid = start + (end - start)/2;
			if(a[mid] > m)
				end = mid - 1;
			else {
				start = mid;
			}
		}
		if(a[end] == m)
			return end;
		else {
			return start;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 2, 4, 5, 6};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.leftMostEqual(a, 3));
		System.out.println(bs.leftMostGreatEqual(a, 3));
		System.out.println(bs.rightMostEqual(a, 3));
		System.out.println(bs.rightMostLessEqual(a, 3));
	}

}
