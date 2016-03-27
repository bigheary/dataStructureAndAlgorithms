package recursion;

public class TailRecurion {
	public static int fibonacci(int n, int a, int b) {
		if(n == 0) return b;
		else {
			return fibonacci(n-1, b, a + b);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = fibonacci(6, 0, 1);//example
		System.out.println(res);
	}

}
