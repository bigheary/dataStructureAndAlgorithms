package hihocoder.netEase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;


public class Solution {
	
	private static ArrayList<TreeSet<Integer>> linkedsets;
	
	/*static{
		linkedsets = new ArrayList<TreeSet<Integer>>();
		linkedsets.set(0, new TreeSet<>(Arrays.asList(1, 4)));
		linkedsets.set(1, new TreeSet<>(Arrays.asList(1, 2, 3, 7)));
		linkedsets.set(2, new TreeSet<>(Arrays.asList(5, 6)));
		linkedsets.set(3, new TreeSet<>(Arrays.asList(1, 7, 0)));
		linkedsets.set(4, new TreeSet<>(Arrays.asList(1, 3, 4, 5, 7, 9)));
		linkedsets.set(5, new TreeSet<>(Arrays.asList(2)));
		linkedsets.set(6, new TreeSet<>(Arrays.asList(1, 4, 7)));
	}*/
	static{
		linkedsets = new ArrayList<TreeSet<Integer>>();
		linkedsets.add(new TreeSet<>(Arrays.asList(1, 4)));
		linkedsets.add(new TreeSet<>(Arrays.asList(1, 2, 3, 7)));
		linkedsets.add(new TreeSet<>(Arrays.asList(5, 6)));
		linkedsets.add(new TreeSet<>(Arrays.asList(1, 7, 0)));
		linkedsets.add(new TreeSet<>(Arrays.asList(1, 3, 4, 5, 7, 9)));
		linkedsets.add(new TreeSet<>(Arrays.asList(2)));
		linkedsets.add(new TreeSet<>(Arrays.asList(1, 4, 7)));
	}

	public static String[] splitBySpace(String str){
		return str.split("\\s+");
	}
	
	public static int[] strParseInt(String[] str){
		int[] t = new int[str.length];
		for(int i = 0; i < str.length; i++){
			t[i] = Integer.parseInt(str[i]);
		}
		return t;
	}
	
	public static int numOfLess(TreeSet<Integer> ts, int v) {
		int count = 0;
		Iterator<Integer> it = ts.iterator();
		while(it.hasNext()){
			if(it.next() < v){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader stdin = new BufferedReader(
        		new InputStreamReader(System.in));
        String S;
        S = stdin.readLine();
        
        for(int s = 0; s < Integer.parseInt(S); s++){
        	String kline = stdin.readLine();
        	String[] klineStrings = splitBySpace(kline);
        	int K = Integer.parseInt(klineStrings[0]);
        	int N = Integer.parseInt(klineStrings[1]);
        	
        	//
        	ArrayList<TreeSet<Integer>> arrayset = new ArrayList(K);
        	for (int k = 0; k < K; k++) {
        		String[] lineStrings = splitBySpace(stdin.readLine().trim());
        		int[] light = strParseInt(lineStrings);
        		TreeSet<Integer> tmpset = new TreeSet<>();
        		tmpset.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        		
        		for(int i = 0; i < light.length; i++){
        			tmpset.removeAll(linkedsets.get(light[i] -1));
        		}
        		arrayset.add(tmpset);
			}
        	
        	//处理
        	int[] arrN = new int[K];
        	for (int n = arrN.length - 1; n > -1; n--) {
				arrN[n] = N % 10;
				N = N/10;
			}
        	
        	int totalLess = numOfLess(arrayset.get(0), arrN[0]);
        	int totaleq = arrayset.get(0).contains(arrN[0])? 1:0;
        	int fl = totalLess;
        	int fe = totaleq;
        	
        	for(int k = 1; k < K; k++){
        		totalLess = numOfLess(arrayset.get(k), arrN[k]);
        		totaleq = arrayset.get(k).contains(arrN[k])? 1:0;
        		
        		fl = fe*totalLess + fl*arrayset.get(k).size();
        		fe = totaleq;
        	}
        	
        	System.out.println(fl);
        }
	}

}
