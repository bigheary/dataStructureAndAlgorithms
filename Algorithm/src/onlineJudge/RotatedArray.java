package onlineJudge;

public class RotatedArray {

	public static int findMin(int[] arr){
		if(arr == null)
			return -1;
		int p = 0, q = arr.length - 1;
		if (arr[p] < arr[q]) {
			return arr[p];
		}
		int mid = 0;
		while(q - p > 1){
			mid = (p + q)/2;
			if(arr[mid] > arr[q]){
				p = mid;
			}
			else {
				q = mid;
			}
		}
		return arr[q];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[]{1, 0, 1, 1, 1}));
	}

}
