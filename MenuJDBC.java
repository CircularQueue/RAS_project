import java.sql.*;

/**
 * Class Description: This class will add, remove, update, and search the database
 * @author Benjamin
 *
 */
public class MenuJDBC {

	private static String url = "jdbc:mysql://localhost:3306/menudatabase";
	private static String username = "root";
	private static String password = "password";
	private Connection conn = null;
	private Statement st = null;
	private DBConnection db;
	private MenuItem item;
	
	/**
	 * This will find an id in the database
	 * @param id the wanted id
	 * @return the id if it was found
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String findID (int id) throws ClassNotFoundException, SQLException{
		String query = "SELECT * FROM menuitem WHERE menu_id = " + id;
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				/*String item_name = rs.getString("item_name");
				int item_price = rs.getInt("item_price");
				String item_description = rs.getString("item_description");
				int item_id = rs.getInt("item_id");
				System.out.println("Found: name: " + item_name + ", price: " + item_price + ", description: " + item_description + ", id: " + item_id);*/
				return item.toString(new MenuItem(rs.getString("item_name"), rs.getInt("item_price"), rs.getString("item_description"), rs.getInt("item_id")));
			}
		}
		catch(SQLException e){
			System.out.print(e.getStackTrace());
		}
		return null;
	}
	
	/**
	 * This will insert a new menuitem to the database
	 * @param item a new menuitem
	 * @return 0 if the item was not added or the id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int insertData(MenuItem item) throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO menuitem" + "(item_name, item_price, item_description)" + " VALUES " + "(\'" + item.getName() + "\', " + item.getPrice() + ", \'" + item.getDescription() + "\', " + item.getID() + ");";
		try{
			conn = getDBConnection();
			st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			return item.getID();
		}
		catch(SQLException e){
			System.out.print(e.getStackTrace());
		}
		return 0;
	}
	
	/**
	 * This will delete a menuitem from the database
	 * @param id the wanted menuitem to be deleted
	 * @return the id that was deleted or 0 if it wasnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int deleteData(MenuItem item)throws ClassNotFoundException, SQLException{
		String sql = "DELETE FROM menuitem WHERE " + "(item_name, item_price, item_description, item_id) = " + "(\'" + item.getName() + "\', " + item.getPrice() + ", \'" + item.getDescription() + "\', " + item.getID() + ");";
		try{
			conn = getDBConnection();
			st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			return item.getID();
		}
		catch(SQLException e){
			System.out.print(e.getStackTrace());
		}
		return 0;
	}
	
	/**
	 * This will update a menuitem from the database
	 * @param id the wanted menuitem to be deleted
	 * @return the id that was updated or 0 if it wasnt
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public MenuItem updateData(MenuItem item, int id)throws ClassNotFoundException, SQLException{
		String sql = "UPDATE menuitem SET item_name = \'" + item.getName() + "\', item_price = " + item.getPrice() + ", item_decription = \'" + item.getDescription() + "\' WHERE item_id = " + id + ";";
		try{
			conn = getDBConnection();
			st = conn.createStatement();
			int rs = st.executeUpdate(sql);
			return item;
		}
		catch(SQLException e){
			System.out.print(e.getStackTrace());
		}
		return null;
	}
	
	/**
	 * This will connect the jdbc to the database
	 * @return the database connection
	 */
	public Connection getDBConnection() throws ClassNotFoundException, SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Connecting to a selected database...");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/menudatabase","root","password");
		    return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
