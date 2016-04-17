package binaryTree;

public class SquenceOfBST {

	public static boolean verifySquenceOfBST(int[] seq, int start, int end)
	throws Exception{
		if (seq == null || start > end) {
			throw new Exception("invaid input");
		}
		int root = seq[end];
		int edge = start;
		while(seq[edge] < root)
			edge++;
		
		int i = edge;
		for(; i < end; i++){//检测右子树节点和根大小
			if(seq[i] < root)
				return false;
		}
		
		boolean left = true;
		if(edge - start > 0)
			left =	verifySquenceOfBST(seq, start, edge-1);
		
		boolean right = true;
		if (edge < end - 1)
			right = verifySquenceOfBST(seq, edge, end - 1);
		
		return left && right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{7, 4, 6, 5};
		try {
			System.out.println(verifySquenceOfBST(null, 0, a.length - 1));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
