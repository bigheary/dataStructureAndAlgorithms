package hihocoder.microsoft.d406;

import java.util.Scanner;

public class Main1 {
	
	public int minFontSize(int[] paghChNum, int pagNum, int w, int h){
		int maxFont = w < h ? w : h;
		int nW = 0, nH = 0;
		int[] lineOfPagh = new int[paghChNum.length];
		int s = maxFont;
		for( ; s > 0; s--){
			nW = w/s;
			nH = h/s;
			int sum = 0;
			for(int i = 0; i < paghChNum.length; i++){
				if(paghChNum[i] % nW == 0){
					lineOfPagh[i] = paghChNum[i] / nW;
					sum += lineOfPagh[i];
				}else {
					lineOfPagh[i] = paghChNum[i] / nW + 1;
					sum += lineOfPagh[i];
				}
			}
			if(sum <= nH * pagNum)
				break;
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for(int t = 0; t < T; t++){
			int N = in.nextInt();
			int P = in.nextInt();
			int W = in.nextInt();
			int H = in.nextInt();
			in.nextLine();
			int[] paghChNum = new int[N];
			for(int n = 0; n < N; n++){
				paghChNum[n] = in.nextInt();
			}
			in.nextLine();
			System.out.println(new Main1().minFontSize(paghChNum, P, W, H));
		}
	}

}
