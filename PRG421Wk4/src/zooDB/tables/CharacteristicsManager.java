package zooDB.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import zooDB.DBType;
import zooDB.DBUtil;
import zooDB.beans.Characteristics;

public class CharacteristicsManager { // class to manage database table "characteristics"

	public static void displayTable() throws SQLException { // beginning of displayTable method

		String sql = "SELECT animalNumber,animalName,animalColor,height," + // SQL statement to select all rows in database table "characteristics"
					 "weight,length FROM characteristics";
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL); // set connection type to "MySQL"
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql); // ResultSet with String SQL above passed in
				){

			System.out.println("Number\t"+ "Name\t\t" + "Color\t"+"Height\t"+"Weight\t"+"Length"); // 
			System.out.println("______________________________________________________");
			
			while (rs.next()) { // while loop to cycle through database table until no data exists in Resultset
				StringBuffer bf = new StringBuffer();
				bf.append(rs.getInt("animalNumber") + ":\t");
				bf.append(rs.getString("animalName") +"\t\t");
				bf.append(rs.getString("animalColor")+ "\t");
				bf.append(rs.getString("height") + "\t");
				bf.append(rs.getString("weight") + "\t");
				bf.append(rs.getString("length"));
				System.out.println(bf.toString());
				
			} // end of while-loop
			
			System.out.println(); // print blank line after table
		} // end of try-with-resources block
		
	} // end of displayTable method

	public static Characteristics getRow(int animalNumber) throws SQLException { // method to retrieve a particular animal by number from database table

		String sql = "SELECT * FROM characteristics WHERE animalNumber = ?";
		ResultSet rs = null;

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, animalNumber);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Characteristics bean = new Characteristics();
				bean.setAnimalNumber(rs.getInt("animalNumber"));
				bean.setAnimalName(rs.getString("animalName"));
				bean.setAnimalColor(rs.getString("animalColor"));
				bean.setHeight(rs.getInt("height"));
				bean.setWeight(rs.getInt("weight"));
				bean.setLength(rs.getInt("length"));
				return bean;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} finally {
			if (rs != null) {
				rs.close();
			}
		}

	}

	public static boolean insert(Characteristics bean) throws Exception {

		String sql = "INSERT into characteristics (animalName, animalColor, height, weight, length) " + // SQL command to insert userName & password
				"VALUES (?, ?, ?, ?, ?)";

		ResultSet keys = null; // declare ResultSet object for try-catch block

		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL); // create connection object
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {

			stmt.setString(1,bean.getAnimalName()); //call getUserName method
			
			stmt.setString(2, bean.getAnimalColor());//call getPassword method
			
			stmt.setInt(3, bean.getHeight());//call getPassword method
			
			stmt.setInt(4, bean.getWeight());//call getPassword method
			
			stmt.setInt(5, bean.getLength());//call getPassword method
					
			int affected = stmt.executeUpdate(); // pass changes to the database

			if (affected == 1) { // check to see if executeUpdate successful
				
				keys = stmt.getGeneratedKeys(); // call ResultSet getGenerated Keys method
				
				keys.next(); // move cursor because cursor starts before 1st row of data
				
				int newKey = keys.getInt(1); // declare variable newKey, pass in value of 1 for 1st column (generated key)
				
				bean.setAnimalNumber(newKey); // setting property of bean object

			} else {
				System.err.println("No rows affected"); // error message if insert method fails
				
				return false;
			}


		} catch (SQLException e) { // catch statement
			
			System.err.println(e);
			
			return false;
			
		} finally{
			
		} if(keys != null) keys.close(); // if keys is not null, close it
			return true;

			
			
	}

	public static boolean update(Characteristics bean) throws Exception { // beginning of "update" method
		
		String sql = "UPDATE characteristics SET " + // SQL command to update animalName,animalColor,height, weight, length
				     "animalName = ?, animalColor = ?," + 
				     "height = ?, weight = ?, length = ? " +
				     "WHERE animalNumber = ?"; // where clause to filter
		
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			
			stmt.setString(1,bean.getAnimalName()); //set each of the values from the java bean to the statement
			stmt.setString(2,bean.getAnimalColor());
			stmt.setInt(3,bean.getHeight());
			stmt.setInt(4,bean.getWeight());
			stmt.setInt(5,bean.getLength());
			stmt.setInt(6,bean.getAnimalNumber());
			
			int affected = stmt.executeUpdate(); // execute update
			
			if (affected == 1){ // if update is successful, boolean true is returned
				return true;
						
			}else {
				
				return false; // if update is not successful, boolean false is returned
			}
		}
		catch(SQLException e) {
			System.err.println(e);
			return false;
		} // end of catch statement
			
	} // end of update method
	
}
				
		
		
		
		
		
		
		
		
