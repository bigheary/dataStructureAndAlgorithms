package onlineJudge;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {

	public int max(int a, int b){
		return a > b ? a : b;
	}
	
	public int longsetPalindrome(String s, int start, int end){
		if(start > end)
			return 0;
		if(start == end)
			return 1;
		if (s.charAt(start) == s.charAt(end)) {
			return 2 + longsetPalindrome(s, start+1, end-1);
		}else {
			return max(longsetPalindrome(s, start + 1, end), longsetPalindrome(s, start, end -1));
		}
	}
	
	public int longsetPalindrome(String s){
		int length = s.length();
		int maxLength = 0;
		int[][] p = new int[length][length];
		for (int i = 0; i < length; i++) {
			p[i][i] = 1;
			
			if(i < length - 1)
				if(s.charAt(i) == s.charAt(i+1)){
					p[i][i+1] = 2;
				//maxLength = 2;
			}else{
					p[i][i+1] = 1;
			}
		}
		
		for(int len = 3; len <= length; len++){
			for(int i = 0; i <= length - len; i++){
				int j = i+len-1;
				if(s.charAt(i) == s.charAt(j))
					p[i][j] = p[i+1][j-1] + 2;
				else{
					p[i][j] = max(p[i+1][j], p[i][j-1]);
				}
			}
		}
		maxLength = p[0][length-1];
		return maxLength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acbadba";
		//System.out.println(new Palindrome().longsetPalindrome(s, 0, s.length() - 1));
		/*System.out.println(new Palindrome().longsetPalindrome(s));
		int[] aa = new int[]{2, 1, 4, 0, 5} ;
		Arrays.sort(aa);
		for(int a : aa){
			System.out.print(a +" ");
		}*/
        Scanner in = new Scanner(System.in);
        int[] xyz = new int[3];
        xyz[0] = in.nextInt();
        xyz[1] = in.nextInt();
        xyz[2] = in.nextInt();
        in.nextLine();
        String seq = in.nextLine();
        System.out.println(seq);
	}

}
