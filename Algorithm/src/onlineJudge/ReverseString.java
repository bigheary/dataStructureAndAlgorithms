package onlineJudge;

public class ReverseString {

	//输入如123 返回“321”
	public static String reverseIntToStr(int n){
		if(n == 0)
			return "";
		int t = n % 10;
		n = n / 10;
		StringBuilder sb = new StringBuilder(String.valueOf((char)(t+'0')));
		return sb.append(reverseIntToStr(n)).toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseIntToStr(-123));
		int n = 1;
		while(n != 0){
			n = n >> 1;
			System.out.println(n);
		}
	}

}
