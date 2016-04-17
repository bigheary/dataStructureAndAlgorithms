package onlineJudge;

public class SumOfFactors {

	public int sumOfFactors(int n){
		if(n <= 0)
			return 0;
		int sums = 0;
		for(int N = 1; N < n+1; N++){
			int num = N;
			int s = 1;
			for(int i = 2; i * i <= num; i++){
				int r = 0;
				while(num % i == 0){
					r++;
					num /= i;
				}
				if(r > 0){
					r++;
					s *= r;
				}
			}
			if( num > 1){
				s *= 2;
			}
			sums += s;
		}
		return sums;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfFactors sf = new SumOfFactors();
		System.out.println(sf.sumOfFactors(10));
	}

}
