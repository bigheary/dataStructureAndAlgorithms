package binaryTree;

import xxd.utils.datastructure.BNode;

public class CreateBinaryTree {
	// 递归地构造树,s1,s2分别问先序、中序序列
	public static BNode createTree(String s1, String s2) {
		if (s1.equals("") && s2.equals("")) {
			return null;
		}
		String charAtRoot = s1.substring(0, 1);
		int index = s2.lastIndexOf(charAtRoot);
		String s11 = s1.substring(1, index+1);
		String s12 = s1.substring(index + 1, s1.length());
		String s21 = s2.substring(0, index);
		String s22 = s2.substring(index+1, s2.length());
		
		BNode root = new BNode(s1.charAt(0), createTree(s11, s21), createTree(s12, s22));
		return root;
	}
	
	//递归地构造树，s1、s2分别为中序、后序序列
	public static BNode createTreeByMA(String s1, String s2) throws Exception {
		if (s1.equals("") && s2.equals("")) {
			return null;
		}
		
		if(s1.length() == 1){
			if (!s1.equals(s2)) {
				throw new Exception("invaid input");
			}
		}
		
		String charAtRoot = s2.substring(s2.length() - 1, s2.length());
		int index = s1.lastIndexOf(charAtRoot);
		if(index < 0)
			throw new Exception("invaid input");
		String s11 = s1.substring(0, index);
		String s12 = s1.substring(index + 1, s1.length());
		String s21 = s2.substring(0, index);
		String s22 = s2.substring(index, s2.length()-1);
		
		BNode root = new BNode(s2.charAt(s2.length() - 1), createTreeByMA(s11, s21), createTreeByMA(s12, s22));
		return root;
	}
	
	public static void main(String[] args){
		/*String s1 = "adbcef";
		String s2 = "dbaecf";*/
		String s1 = "47215386";
		String s2 = "40258631";
		try {
			BNode root = createTreeByMA(s1, s2);
			//visit
			System.out.print("先序遍历： ");
			BNodeProcessor.visitTreeRecursiveNlr(root);
			System.out.println();
			System.out.print("中序遍历： ");
			BNodeProcessor.visitTreeRecursiveLnr(root);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

		
	}
}
