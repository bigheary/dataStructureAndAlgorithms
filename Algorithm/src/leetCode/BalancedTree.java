package leetCode;

import binaryTree.CreateBinaryTree;
import xxd.utils.datastructure.BNode;

public class BalancedTree {
    public boolean isBalanced(BNode root) {
        int[] depth = new int[1];
        return isBananced(root, depth);
    }
    
    public boolean isBananced(BNode root, int[] depth){
        if(root == null){
            depth[0] = 0;
            return true;
        }
        
        int[] htLeft = new int[1];
        int[] htRight = new int[1];
        if(isBananced(root.getLeft(), htLeft) &&
                isBananced(root.getLeft(), htRight)){
                    int diff = htLeft[0] - htRight[0];
                    if(diff <= 1 && diff >= -1){
                        depth[0] = 1 + (htLeft[0] > htRight[0] ? htLeft[0]:htRight[0]);
                        return true;
                    }
                }
        return false;
    }
    
    public static void main(String[] args){
    	BalancedTree bt = new BalancedTree();
    	BNode root = CreateBinaryTree.createTree("123", "123");
    	System.out.println(bt.isBalanced(root));
    }
    
}