package onlineJudge;

public class GrayCode {
	//递归输出n位格雷码
	public static String[] grayCode(int n){
		String[] code = new String[(int)Math.pow(2, n)];
		if(n == 1){
			code[0] = "0";
			code[1] = "1";
			return code;
		}
		
		
		String[] subCode = grayCode(n - 1);
		for(int i = 0; i < code.length/2; i++){
			code[i] = "0" + subCode[i];
			code[code.length - i -1] = "1" + subCode[i];
		}
		return code;
	}
	
	// 非递归实现
	/*public static String[] grayCodeNonRecursive(int n){
		return ;
	}*/
	
	
	//从二进制映射到格雷码
	public static void getGrayCode(int n){
		int num = (int)Math.pow(2, n);
		
		for(int i = 0; i < num; i++){
			String s = "";
			int t = i ^ (i >> 1);
			for(int in = n-1; in >= 0; in--){
				s += (t>>in) & 1;
			}
			System.out.println(s);
		}
	}
	
	public static void main(String[] args){
		//getGrayCode(4);
		String[] ss = grayCode(1);
		for(String str: ss)
			System.out.println(str);
	}
}
