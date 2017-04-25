package model;

import java.util.ArrayList;

/**
 * A generic interface consisting of basic JDBC database actions that any entity class with a corresponding database table should implement 
 * @author Phillip Witkin
 *
 * @param <Entity> The entity class which will utilize these JDBC actions
 */
public interface CommonJDBC<Entity> {
	
	/**
	 * Finds an object's entry in the database searching for its ID as primary key
	 * @param ID an Integer representation of the ID to search
	 * @return The entity in the database with the corresponding ID. Returns null if no match is found. 
	 */
	public Entity finByID(int ID);
	
	/**
	 * Finds a collection of objects in the database matching a SQL Where clause
	 * @param SQLWhere String representation of the WHERE portion of an SQL command
	 * @return an ArrayList of objects matching database entries. Returns null if no matches found.
	 */
	public ArrayList<Entity> findWhere(String SQLWhere);
	
	/**
	 * Updates a given object's database information with new information. Cannot update an ID.
	 * @param updatedEntity The updated object data; Can have unchanged fields blank, but must contain an ID to update proper entry.
	 * @return The updated object with all of its new data. Returns null if the ID in the updatedEntity parameter has no match. 
	 */
	public Entity update(Entity updatedEntity);
	
	/**
	 * Inserts a new entry in the appropriate in the appropriate database table(s) for this object
	 * @param newEntity An object representing a new database entry
	 * @return The newly created object. Returns null if INSERT was not sucessful.
	 */
	public Entity create(Entity newEntity);
	
	/**
	 * Delete an entry from the appropriate database table with a matching primary key
	 * @param ID An integer representing the ID of the object with a matching primary key to be deleted
	 * @return An object representation of the deleted database entry. Returns null if no match for ID was found.
	 */
	public Entity deleteByID(int ID);
}
