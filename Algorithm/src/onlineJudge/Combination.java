package onlineJudge;

public class Combination {
	public static String[] getComb(String s){
		String[] com = new String[(int)Math.pow(2, s.length())];
		if(s.length() == 1){
			com[0] ="";
			com[1] = s;
			return com;
		}
		
		String[] sub = getComb(s.substring(1, s.length()));
		for(int i = 0; i < com.length / 2; i++){
			com[i] = sub[i];
			com[com.length / 2 + i] = s.substring(0, 1) + sub[i];
		}
		return com;
	}
	
	public static void main(String[] args){
		for(String ss: getComb("ABC"))
			System.out.println(ss);
	}
}
