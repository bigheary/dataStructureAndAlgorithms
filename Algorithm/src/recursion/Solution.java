package recursion;

public class Solution {

	private static int M = 997;
	private static int index = 9;
	// log(N!)
	public double logfactorial(int n) {
		if (n == 1) {
			return 0;
		}
		return Math.log10(n) + logfactorial(n-1);
	}
	
	// N! mod M for N = 10^6 do not overflow
	public int factorialmod(int n){
		if (n == 1) {
			return 1;
		}
		return n*factorialmod(n-1) % M;
	}
	
	//non factorial gcd algorithms
	public int nonFactorialGcd(int m, int n){
		if(m == 0 || n == 0)
			return 0;
		int remainder = m % n;
		while(remainder != 0){
			m = n;
			n = remainder;
			remainder = m % n;
		}
		return n;
	}
	
	//find primes less than N
	public int[] findPrimes(int n){
		if (n < 2) {
			return null;
		}
		int length = 0;
		int[] primestore = new int[n];
		
		primestore[0] = 2;
		length = 1;
		
		// try every number
		for (int nt = 3; nt < n; nt++) {
			int j = 0;
			int limit = (int)Math.sqrt((double)nt);
			
			/*for (j = 0; j < length; j++) {
				// < sqrt(N)
				if (primestore[j] > limit) {
					break;
				}
				if ((nt % primestore[j]) == 0) {
					break;
				}
			}
			if (j == length) {
				System.out.println("stop here");
			}
			if(primestore[j] > limit || j == length){
				primestore[length] = nt;
				length++;
			}
		}*/
			for (j = 0; primestore[j] <= limit; j++) {
				// < sqrt(N)
				if ((nt % primestore[j]) == 0) {
					break;
				}
			}

			if(primestore[j] > limit ){
				primestore[length] = nt;
				length++;
			}
		}
		
		int[] primes = new int[length];
		for(int i = 0; i < length; i++){
			primes[i] = primestore[i];
		}
		
		return primes;
	} 
	
	public void mark(int m, int n){
		if (m == index) {
			//System.out.println("index : "+ m +", length: "+ n);
		}
		System.out.println("index : "+ m +", length: "+ n);
	}
	
	// mark the ruler with marker length
	public void rule(int l, int r, int n){
		int m = (l + r) / 2;
		if(n > 0){
			rule(l, m-1, n-1);
			mark(m, n);
			rule(m+1, r, n-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sl = new Solution();
		//System.out.println(sl.factorialmod(7));
		//System.out.println(sl.nonFactorialGcd(32, 7));
		
		/*int[] primes = sl.findPrimes(100);
		for (int i : primes) {
			System.out.print("\t"+i);
		}*/
		int n = 4;
		sl.rule(0, 11, 4);
		
	}

}
