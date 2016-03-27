package onlineJudge;

import xxd.utils.algorithms.*;

/*
 *数组出现次数多于一半的数字
 * 
 */
public class MoreThanHalfNum {

	public static int moreThanHalfNum(int[] arr){
		
		if(checkInvaidArray(arr))
			return 0;
		
		int middle = (arr.length) / 2;
		int start = 0; 
		int end = arr.length - 1;
		int index = Qsort.partition(arr, start, end);
		while(index != middle){
			if(index > middle ){
				end = index - 1;
				index = Qsort.partition(arr, start, end);
			}else{
				start = index + 1;
				index = Qsort.partition(arr, start, end);
			}
		}
		int result = arr[middle];
		if(!checkMoreThanHalf(arr, result))
			return 0;
		return result;
	}
	
	public static int moreThanHalfNumOn(int[] arr){
		
		if(checkInvaidArray(arr))
			return 0;
		int result = arr[0];
		int count = 1;
		for(int i = 1; i < arr.length; i++){
			if(count == 0){
				result = arr[i];
			    count = 1;
			    continue;
			}
			else if(result == arr[i]){
				count++;
			}else{
				count--;
			}
		}
		
		if(!checkMoreThanHalf(arr, result))
			return 0;
		return result;
	}
	
	public static boolean checkMoreThanHalf(int[] arr, int result){
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == result)
				count++;
		}
		if(count * 2 > arr.length)
			return true;
		else 
			return false;
	}
	
	//invaid 返回true
	public static boolean checkInvaidArray(int[] arr){
		boolean inputInvaid = false;
		if (arr == null) {
			inputInvaid = true; 
		}
		return inputInvaid;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3, 3, 3, 3, 2, 2, 2, 2, 2};
		int mtfn = moreThanHalfNum(a);
		int mtfn1 = moreThanHalfNumOn(a);
		System.out.println(mtfn);
		System.out.println(mtfn1);
	}

}
