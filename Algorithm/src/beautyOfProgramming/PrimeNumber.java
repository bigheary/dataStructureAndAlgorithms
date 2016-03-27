package beautyOfProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javaIO.StdIOUtils;

public class PrimeNumber {

    
    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader(
        		new InputStreamReader(System.in));
        String s = stdin.readLine();
        
        int n = Integer.parseInt(s);
        ArrayList<Integer> primeholder = new ArrayList<Integer>(n);
        primeholder.add(2);
        for(int num = 3; num < n; num++){
        	Iterator<Integer> it = primeholder.iterator();
        	int factor = it.next();
        	boolean flag = true;
        	while(factor < Math.sqrt(num)+1 && it.hasNext()){
        		if (num % factor == 0) {
        			flag = false;
					break;
				}
        		factor = it.next();
        	}
        	if(flag)
        		primeholder.add(num);
        }
        
        System.out.println(primeholder);
        
        
	}
    
}
