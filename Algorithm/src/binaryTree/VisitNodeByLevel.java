package binaryTree;

import java.util.ArrayList;

import xxd.utils.datastructure.BNode;

public class VisitNodeByLevel {
	
	//递归地打印二叉树level层的节点
	public static int printNodeAtLevel(BNode root, int level) {
		if (null == root || level < 0) {
			return 0;
		}
		if(0 == level){
			System.out.print(root.getData()+" ");
			return 1;
		}
		return printNodeAtLevel(root.getLeft(), level-1) + printNodeAtLevel(root.getRight(), level-1);
	}
	
	public static void printNodeByLevel(BNode root) {
		for (int  level = 0; ; level++) {
			if (0 == printNodeAtLevel(root, level)) {
				break;
			}
			System.out.println();
		}
	}
	
	public static void printNodeByLevel1(BNode root) {
		if (root == null) {
			return;
		}
		ArrayList<BNode> arr = new ArrayList<>();
		ArrayList<Integer> index = new ArrayList<>();
		//index.add(0);
		arr.add(root);
		int current = 0;
		while(current < arr.size()){
			int last = arr.size();
			while (current < last) {
				System.out.print(arr.get(current).getData()+" ");
				if (arr.get(current).getLeft() != null)
					arr.add(arr.get(current).getLeft());
				if (arr.get(current).getRight() != null)
					arr.add(arr.get(current).getRight());	
				current++;
			}
			System.out.println();
			index.add(last);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BNode root = CreateBinaryTree.createTree("abdcef", "dbaecf");
		printNodeByLevel(root);
		printNodeByLevel1(root);
	}

}
