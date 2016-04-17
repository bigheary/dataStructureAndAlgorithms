package onlineJudge;

public class BigNumber {

	public static void print1ToMaxNDigits(int n){
		if(n <= 0)
			return;
		char[] arr = new char[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = '0';
		}
		while(!increment(arr)){
			printNumber(arr);
		}
	}
	
	//使用char数组进行大数的加一运算
	public static boolean increment(char[] arr) {
		boolean flag = false;
		//arr[arr.length - 1] += 1;
		int position = arr.length - 1;
		if (arr[position] == '9') {
			arr[position--] = '0';
			flag = true;	
			while(flag && position >= 0){
				
				if (arr[position] != '9') {
					arr[position] += 1;
					flag = false;
				}else {
					arr[position] = '0';
				}
				position--;
			}
		}else {
			arr[position] += 1;
		}
		
		return flag;
	}
	
	public static void printNumber(char[] arr) {
		int i = 0;
		while (arr[i] == '0' && (i < arr.length-1)) {
			i++;
		}
		for (int j = i; j < arr.length; j++) {
			System.out.print(arr[j]);
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print1ToMaxNDigits(2);
	}

}
