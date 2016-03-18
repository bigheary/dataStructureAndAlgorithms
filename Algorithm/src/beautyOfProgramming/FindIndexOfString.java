package beautyOfProgramming;

public class FindIndexOfString {
	
	public static int getIndexOfStringRightMost(String[] arr, String v) {
		
		int begin = 0, end = arr.length-1, mid = 0;
		while(begin < end-1){
			mid = begin + (end - begin)/2;
			/*if (arr[mid].compareTo(v) >= 0) {
				end = mid;
			}else{
				begin = mid+1;				
			}*/
			//因为mid可能等于begin而绝不会等于end，所以在用mid更新begin时要注意防止死循环的问题
			//这里就要注意，所以需要用
			if (arr[mid].compareTo(v) <= 0) {
				begin = mid;
			}else{
				end = mid-1;				
			}
		}
		
		//找到了
		if (arr[end].compareTo(v) == 0) {
/*			while(arr[end].compareTo(v) == 0)
				end++;
			end--;*/
			return end;
		}else if(arr[begin].compareTo(v) == 0){
			return begin;
		}else{//没找到
			return -1;
		}

	}
	
public static int getIndexOfStringLeftMost(String[] arr, String v) {
		
		int begin = 0, end = arr.length-1, mid = 0;
		while(begin < end){
			mid = (begin + end)/2;
			/*if (arr[mid].compareTo(v) >= 0) {
				end = mid;
			}else{
				begin = mid+1;				
			}*/
			//因为mid可能等于begin而绝不会等于end，所以在用mid更新begin时要注意防止死循环的问题
			//而这里就不用了
			if (arr[mid].compareTo(v) >= 0) {
				end = mid;
			}else{
				begin = mid+1;				
			}
		}
		
		//找到了
		if (arr[begin].compareTo(v) == 0) {
/*			while(arr[end].compareTo(v) == 0)
				end++;
			end--;*/
			return begin;
		}else if(arr[end].compareTo(v) == 0){
			return end;
		}else{//没找到
			return -1;
		}

	}
public static int getIndexOfStringArbitrary(String[] arr, String v) {
	
	int begin = 0, end = arr.length-1, mid = 0;
	while(begin < end-1){
		mid = (begin + end)/2;
		/*if (arr[mid].compareTo(v) >= 0) {
			end = mid;
		}else{
			begin = mid+1;				
		}*/
		if (arr[mid].compareTo(v) < 0) {
			begin = mid+1;
		}else if(arr[mid].compareTo(v) > 0){
			end = mid-1;				
		}else{
			break;
		}
	}
	
	//找到了
	if (arr[mid].compareTo(v) == 0) {
/*			while(arr[end].compareTo(v) == 0)
			end++;
		end--;*/
		return mid;
	}/*else if(arr[begin].compareTo(v) == 0){
		return begin;
	}*/else{//没找到
		return -1;
	}

}

public static int getIndexOfStringMostLessThan(String[] arr, String v) {
	
	int begin = 0, end = arr.length-1, mid = 0;
	while(begin < end-1){
		mid = (begin + end)/2;
		/*if (arr[mid].compareTo(v) >= 0) {
			end = mid;
		}else{
			begin = mid+1;				
		}*/
		if (arr[mid].compareTo(v) >= 0) {
			end = mid-1;
		}else{
			begin = mid;
		}
	}
	
	//找到了
	if (arr[end].compareTo(v) < 0) {
/*			while(arr[end].compareTo(v) == 0)
			end++;
		end--;*/
		return end;
	}/*else if(arr[begin].compareTo(v) == 0){
		return begin;
	}*/else{//没找到
		return -1;
	}

}

public static int getIndexOfStringLeastMoreThan(String[] arr, String v) {
	
	int begin = 0, end = arr.length-1, mid = 0;
	while(begin < end-1){
		mid = (begin + end)/2;
		/*if (arr[mid].compareTo(v) >= 0) {
			end = mid;
		}else{
			begin = mid+1;				
		}*/
		if (arr[mid].compareTo(v) <= 0) {
			begin = mid+1;
		}else{
			end = mid;
		}
	}
	
	//找到了
	if (arr[begin].compareTo(v) > 0) {
/*			while(arr[end].compareTo(v) == 0)
			end++;
		end--;*/
		return begin;
	}/*else if(arr[begin].compareTo(v) == 0){
		return begin;
	}*/else{//没找到
		return -1;
	}

}

public static int getIndexOfStringLeastMoreOrEqualThan(String[] arr, String v) {
	
	int begin = 0, end = arr.length-1, mid = 0;
	while(begin < end){
		mid = (begin + end)/2;
		/*if (arr[mid].compareTo(v) >= 0) {
			end = mid;
		}else{
			begin = mid+1;				
		}*/
		if (arr[mid].compareTo(v) < 0) {
			begin = mid+1;
		}else{
			end = mid;
		}
	}
	
	//找到了
	if (arr[begin].compareTo(v) >= 0) {
/*			while(arr[end].compareTo(v) == 0)
			end++;
		end--;*/
		return begin;
	}else if(arr[end].compareTo(v) >= 0){
		return end;
	}else{//没找到
		return -1;
	}

}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"aa","bb","cc","dd","ee","ff","ff","gg","gg","ss","tt"};
		String v = "gg";
		//getIndexOfStringArbitrary(arr, v);
		//int indexLeftMost = getIndexOfStringLeftMost(arr, v);
		int indexRightMost = getIndexOfStringRightMost(arr, v);
		//int indexArbitrary = getIndexOfStringArbitrary(arr, v);
		//System.out.println(indexLeftMost+" "+" "+indexRightMost+" "+indexArbitrary);
		
		//getIndexOfStringMostLessThan(arr, v);
		//getIndexOfStringLeastMoreThan(arr, v);
		//getIndexOfStringLeastMoreOrEqualThan(arr, v);
	}

}
