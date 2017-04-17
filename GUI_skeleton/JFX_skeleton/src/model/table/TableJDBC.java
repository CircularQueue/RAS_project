package model.table;

import java.util.ArrayList;

import model.BaseJDBC;
import model.CommonJDBC;
import model.employee.Server;

public class TableJDBC extends BaseJDBC<Table> implements CommonJDBC<Table>{

	@Override
	public Table finByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Table> findWhere(String SQLWhere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table update(Table updatedTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table create(Table newTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table deleteByID(int tabkeID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Server finServerForTable(int tableID){
		return null;
	}
	
	public ArrayList<Table> findTablesForServer(int serverID){
		return null;
	}
	
	
	
	

}
