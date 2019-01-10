package com.demo.training1;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
//DATABASE CONNECTION
public class Javaconnection {
	static  Connection connection=null;
	static {
		try {
			// Load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Get a connection
			 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			 }
		catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}
	
  public static void insertFile(int customerId, String CustomerCode, String CustomerName,String  CustomerAddress1,String CustomerAddress2,String CustomerPinCode,String Emailaddress,String ContactNumber,String PrimaryContactPerson,String RecordStatus,String ActiveInactiveFlag,String CreateDate, String CreatedBy,String ModifiedDate, String ModifiedBy,String AuthorizedDate,String AuthorizedBy) throws SQLException {
			try {

				//Create a prepared statement
				PreparedStatement pre = connection.prepareStatement("insert into NINMASTERCUSTOMER1 values('" + customerId + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                  //pre.setString(1, '1');
			      pre.setString(1,CustomerCode );
			      pre.setString(2,CustomerName );
			      pre.setString(3, CustomerAddress1);
			      pre.setString(4,CustomerAddress2 );
			      pre.setString(5,CustomerPinCode);
			      pre.setString(6, Emailaddress);
			      pre.setString(7,ContactNumber );
			      pre.setString(8,PrimaryContactPerson );
			      pre.setString(9, RecordStatus);
			      pre.setString(10,ActiveInactiveFlag );
			      pre.setString(11,CreateDate);
			      pre.setString(12,CreatedBy );
			      pre.setString(13,ModifiedDate );
			      pre.setString(14, ModifiedBy);
			      pre.setString(15,AuthorizedDate );
			      pre.setString(16,AuthorizedBy);
			      //EXECUTE THE STATEMENT
			      pre.executeUpdate();
			
			} catch (SQLException exception) {
				System.out.println("insertFile " + exception);
			}
			
		}
	}


