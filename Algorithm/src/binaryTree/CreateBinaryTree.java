package binaryTree;

public class CreateBinaryTree {
	// 递归地构造树
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
	
	public static void main(String[] args){
		String s1 = "adbcef";
		String s2 = "dbaecf";
		BNode root = createTree(s1, s2);
		
		//visit
		System.out.print("先序遍历： ");
		BNodeProcessor.visitTreeRecursiveNlr(root);
		System.out.println();
		System.out.print("中序遍历： ");
		BNodeProcessor.visitTreeRecursiveLnr(root);
		
	}
}
