package model;

import java.util.ArrayList;

/**
 * 
 * @author Phillip Witkin
 *
 * @param <Entity> The Entity class which will have JDBC actions
 */
public abstract class BaseJDBC<Entity> implements CommonJDBC<Entity> {
	
	public abstract Entity finByID(int ID); 

	
	public abstract ArrayList<Entity> findWhere(String SQLWhere);
	

	public abstract Entity update(Entity updatedEntity);


	public abstract Entity create(Entity newEntity);


	public abstract Entity deleteByID(int ID); 

}
