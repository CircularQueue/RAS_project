import java.util.HashMap;

/**
 * 
 * @author Benjamin
 * Class Name: Menu
 * Description: This class adds, removes, search, and updates items to the menu and views the menu.
 *
 */
public class Menu {
	
	/**
	 * This is used to store all of the MenuItems.
	 */
	private HashMap<String, Integer> hmap = new HashMap<String, Integer>();
	
	/**
	 * This method will create a new MenuItem with the given name and price and add that to the Hashmap.
	 * @param name Name to be added
	 * @param price Price to be added
	 */
	public void addItem(String name, int price){
		
	}
	
	/**
	 * This method will search the hashmap for the wanted MenuItem.
	 * @param name The name of the item to be searched for
	 * @return True if the item is found or false if the item is not found
	 */
	public boolean searchItem(String name){
		
	}
	
	/**
	 * This method will call on the search method to look for an item,
	 * then if that item is found it will be removed from the hashmap with it's price.
	 * @param name The name of the item to be removed
	 * @return True if the item was removed or false if the item was not removed
	 */
	public boolean removeItem(String name){
		
	}
	
	/**
	 * This method will call on the search method to look for an item,
	 * then if that item is found it will change that item's name or price.
	 * @param name The name of the item to be changed
	 * @return True if the item was updated or false if it was unchanged
	 */
	public boolean updateItem(String name){
		
	}
	
	/**
	 * This method will return the entire hashmap
	 * @return The current menu status
	 */
	public String viewMenu(){
		
	}
	
}
