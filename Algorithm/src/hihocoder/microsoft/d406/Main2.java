package hihocoder.microsoft.d406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main2 {
	
	public boolean matchRequest(String rule, String request){
		if(rule.lastIndexOf('/') > 0){
			int[] pointIndex = new int[5];
			int pieIndex = 0;
			pointIndex[0] = -1;
			for(int i = 0, j = 0; i < rule.length(); i++){
				if (rule.charAt(i) == '.') {
					pointIndex[++j] = i;
				}else if (rule.charAt(i) == '/') {
					pieIndex = i;
					pointIndex[++j] = i;
				}
			}
			int numMask = Integer.parseInt(rule.substring(pieIndex+1, rule.length()));
			if (!rule.substring(0, pointIndex[numMask/8]+1)
					.equals(request.substring(0,  pointIndex[numMask/8]+1))) {
				return false;
			}
			int numAddress = Integer.parseInt(rule.substring(pointIndex[numMask/8]+1, pointIndex[numMask/8+1]));
			int numRequest = Integer.parseInt(request.substring(pointIndex[numMask/8]+1, pointIndex[numMask/8+1]));
			int m = numMask % 8;
			if(m == 0)
				return true;
			int shift = 0xFFFFFF80;
			shift = shift >> m - 1;
			if((numAddress & shift) == (numRequest & shift)){
		    	return true;
		    }
			return false;
		}else {
			return rule.equals(request);
		}
	}
	
	public boolean checkRequest(LinkedList<String> rules, String request){
		for(String rule : rules){
			String[] ruleStr = rule.split(" ");
			if(matchRequest(ruleStr[1], request)){
				if(ruleStr[0].equals("deny")){
					return false;
				}else {
					return true;
				}
			}
		}
		return true;
	}
	
/*	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		in.nextLine();
		LinkedList<String> rules = new LinkedList<>();
		//ArrayList<String> request = new ArrayList<>(M);
		Main2 solution = new Main2();
		for(int n = 0; n < N; n++){
			rules.add(in.nextLine());
		}
		for(int m = 0; m < M; m++){
			String request = in.nextLine();
			if(solution.checkRequest(rules, request)){
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		in.close();
	}*/
	
    public int[] lineToInt(String s){
        if(s == null)
            return null;
        String[] tmp = s.split(" ");
        int[] arr = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        return arr;
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 20001);
		Main2 solution = new Main2();
		int[] tmpdata = solution.lineToInt(br.readLine());
		int N = tmpdata[0];
		int M = tmpdata[1];
		LinkedList<String> rules = new LinkedList();
		for(int n = 0; n < N; n++){
			rules.add(br.readLine());
		}
		for(int m = 0; m < M; m++){
			String request = br.readLine();
			if(solution.checkRequest(rules, request)){
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
