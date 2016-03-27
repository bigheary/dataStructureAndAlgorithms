package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***************
 * 这是一个作为OJ常用的IO以及类型转换工具
 * @author xxd
 */
public class StdIOUtils {

	//将空白符全部去掉
	public static String[] splitBySpace(String str){
		return str.split("\\s+");
	}
	
	//将string数组转换为int数组
	public static int[] strParseInt(String[] str){
		int[] t = new int[str.length];
		for(int i = 0; i < str.length; i++){
			t[i] = Integer.parseInt(str[i]);
		}
		return t;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        BufferedReader stdin = new BufferedReader(
        		new InputStreamReader(System.in));
        String s = stdin.readLine();
	}

}
