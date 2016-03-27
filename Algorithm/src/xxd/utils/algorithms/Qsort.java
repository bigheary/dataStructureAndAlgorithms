package xxd.utils.algorithms;

import java.util.Random;

public class Qsort {

	public static int partition(int[] arr, int start, int end){
		int low = start;
		int high = end - 1;
		int index = getRandomBetween(start, end);//区间包含
		//int index = 8;
		swap(arr, index, end);
		
		while(low < high){
			while(arr[low] < arr[end])
				low++;
			while(arr[high] > arr[end] && high > 0)//防止high = -1
				high--;
			if (low < high) {//防止在内部超出
				swap(arr, low, high);
				low++;
				high--;
			}else{
				break;
			}
			
		}
		while(arr[low] < arr[end])
			low++;
		swap(arr, low, end);
		
		return low;
		
		
	}
	
	//获取区间[start, end]内的int型随机数
	public static int getRandomBetween(int start, int end){
		Random rnd = new Random();
		return rnd.nextInt(end - start + 1) + start;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return;
	}
	
	public static void qSort(int[] arr, int start, int end){
		if(start == end){
			return;
		}
		
		int index = partition(arr, start, end);
		if(index > start)
			qSort(arr, start, index - 1);
		if(index < end)
			qSort(arr, index + 1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] a = {1, 2, 8, 6, 3, 4, 0, 9, 5};
         //int i = partition(a, 0, a.length - 1);
         qSort(a, 0, a.length - 1);
         for(int b: a)
        	 System.out.println(b);
	}

}
