package recursion;



public class Dynamic {

	class Item{
		private int size;
		private int val;
	}
	
	private int cap;
	private int[] maxKnown;
	private int[] itemKnown;
	Item[] items = new Item[5];
	
	{
		for(int i = 0; i < 5; i++){
			items[i] = new Item();
		}
		items[0].size = 3; items[0].val = 4;
		items[1].size = 4; items[1].val = 5;
		items[2].size = 7; items[2].val = 10;
		items[3].size = 8; items[3].val = 11;
		items[4].size = 9; items[4].val = 13;
	}
	
	Dynamic(int cap) {
		this.cap = cap;
		maxKnown = new int[cap+1];
		itemKnown = new int[cap+1];
		for(int i = 0; i< cap+1; i++){
			maxKnown[i] = -1;
		}
	}
	
	public int knap(int cap) {
		int i, space, max, maxi, t;
		maxi = -1;
		if(maxKnown[cap] != -1) return maxKnown[cap];
		for(i = 0, max = 0; i < 5; i++)
			if((space = cap - items[i].size) >= 0){
				if((t = knap(space) + items[i].val) > max){
					max = t;
					maxi = i;
				}
			}
		maxKnown[cap] = max;
		if (maxi == -1) {
			itemKnown[cap] = 0;
			return max;
		}
		itemKnown[cap] = items[maxi].size;
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cap = 17;
		Dynamic dy = new Dynamic(cap);
		dy.knap(cap);
		
		while(true){
			System.out.println(dy.itemKnown[cap]);
			cap = cap - dy.itemKnown[cap];
			if(cap == 0)
				break;
		}
	}

}
