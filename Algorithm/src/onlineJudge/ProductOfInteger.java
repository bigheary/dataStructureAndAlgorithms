package onlineJudge;

public class ProductOfInteger {
	
	public long product(int n1, int n2){
		boolean sign1 = (n1 < 0);
		boolean sign2 = (n2 < 0);
		n1 = sign1 ? -n1:n1;
		n2 = sign2 ? -n2:n2;
		
		long result = 0;
		if((n2 & 1) == 1)
			result += n1;
		n2 = n2>>1;
		while (n2 != 0) {
			if((n2 & 1) == 1){
				n1 = n1<<1;
				result += n1;
			}
			n2 = n2>>1;
		}
		
		if(sign1 ^ sign2){
			return -result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ProductOfInteger().product(-9, 0));
	}

}
