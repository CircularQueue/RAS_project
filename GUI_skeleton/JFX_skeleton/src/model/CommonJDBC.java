package model;

import java.util.ArrayList;

public interface CommonJDBC<Entity> {

	public Entity finByID(int ID);
	public ArrayList<Entity> findWhere(String SQLWhere);
	public Entity update(Entity updatedEntity);
	public Entity create(Entity newEntity);
	public Entity deleteByID(int ID);
}
