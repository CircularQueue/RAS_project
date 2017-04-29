import java.util.ArrayList;

public class Items {
	private ArrayList<Item> list;
	private Item item1;
	
	public Items(int size){
		list = new ArrayList<Item>(size);
		item1 = new Item(5);
		list.add(item1);
	}

}
