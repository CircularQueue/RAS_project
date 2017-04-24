import java.util.ArrayList;

/**
 * 
 * @author Benjamin
 * Class Name: Menu
 * DESCRIPTION: This class adds, removes, search, and updates items to the menu and views the menu.
 *
 */
public class Menu {
	
	/**
	 * This is used to store all of the MenuItems.
	 */
	private ArrayList list;
	
	/**
	 * This method will create a new MenuItem with the given name and price and add that to the Hashmap.
	 * @param item The menu item that needs to be added
	 * @return true if the item was added or false if the item was not added
	 */
	
	public boolean addItem(MenuItem item){
		
	}
	
	/**
	 * This method will search the hashmap for the wanted MenuItem.
	 * @param name The name of the item to be searched for
	 * @return the menu item that was searched for
	 */
	public MenuItem searchItem(int id){
		
	}
	
	/**
	 * This method will call on the search method to look for an item,
	 * then if that item is found it will be removed from the hashmap with it's price.
	 * @param name The name of the item to be removed
	 * @return the MenuItem that was removed
	 */
	public MenuItem removeItem(int id){
		
	}
	
	/**
	 * This method will call on the search method to look for an item,
	 * then if that item is found it will change that item's name or price.
	 * @param name The name of the item to be changed
	 * @return the menu item that was updated
	 */
	public MenuItem updateItem(ind id){
		
	}
	
	/**
	 * This method will return the entire ArrayList
	 * @return The current menu status
	 */
	public ArrayList viewMenu(){
		
	}
	
	/**
	 * This method will output everything as a string
	 * @return a string of text
	 */
	public String toString(){
		
	}
	
}
