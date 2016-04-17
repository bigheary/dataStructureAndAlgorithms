package languageBasics;

class Int{
	private int val;
	
	public Int(int val){
		this.val = val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
}

public class ParameterValue {
	

	
	public static void changeInt(Int it){
		it.setVal(100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer it = 0;
		//changeInt(it);
		Int it = new Int(0);
		changeInt(it);
		System.out.println(it.getVal());
	}

}
