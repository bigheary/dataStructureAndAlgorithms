package onlineJudge;

class AscendSpuer{
	private int i ;
	public AscendSpuer() {
		// TODO Auto-generated constructor stub
		System.out.println("super constructor");
	}
}

public class AscendingAndDescendingArray extends AscendSpuer{
	
	public AscendingAndDescendingArray(){
		System.out.println("hello");
	}
	
	public boolean testValue(int[] arr, int value){
		
		int maxIndex = findIndexOfMax(arr);
		boolean startBigger = arr[0] > arr[arr.length - 1] ? true:false;
		if (value > arr[maxIndex]) {
			return false;
		}else if(value == arr[maxIndex]) {
			return true;
		}
		
		if (startBigger) {
			if (value < arr[arr.length - 1]) {
				return false;
			}
			
			/*if (descendingFind(arr, maxIndex, arr.length - 1, value)) {
				return true;
			}else if(ascendingFind(arr, 0, maxIndex, value)){
				return true;
			}*/
			return descendingFind(arr, maxIndex, arr.length - 1, value) || ascendingFind(arr, 0, maxIndex, value);
			
		}else {
			if(value < arr[0]){
				return false;
			}
			
			return ascendingFind(arr, 0, maxIndex, value) || descendingFind(arr, maxIndex, arr.length - 1, value);
			
		}
	}
	
	public boolean descendingFind(int[] arr, int start, int end, int value){
		if (start > end) {
			return false;
		}
		int mid = 0;
		while(start < end){
			mid = (start + end) >> 1;
		    if(arr[mid] > value){
		    	start = mid + 1;
		    }else{
		    	end = mid;
		    }
		}
		if (arr[end] == value) {
			return true;
		}
		return false;
	}
	
	public boolean ascendingFind(int[] arr, int start, int end, int value){
		if (start > end) {
			return false;
		}
		
		int mid = 0;
		while(start < end){
			mid = (start + end) >> 1;
		    if(arr[mid] < value){
		    	start = mid + 1;
		    }else{
		    	end = mid;
		    }
		}
		if (arr[end] == value) {
			return true;
		}
		return false;
	}
	
	public int findIndexOfMax(int[] arr){
		if(arr == null )
			return -1;
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while(start < end){
			mid = (start + end) >> 1;
			if(arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]){
				start = mid + 1;
			}else if(arr[mid - 1] > arr[mid]  && arr[mid] > arr[mid + 1]){
				end = mid - 1;
			}else if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid+1]){
				return mid;
			}
		}
		if (arr[end] > arr[end - 1] && arr[end] > arr[end+1]) {
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		AscendingAndDescendingArray aaa = new AscendingAndDescendingArray();
		System.out.println(new AscendingAndDescendingArray().testValue(arr, 2));
	}

}
