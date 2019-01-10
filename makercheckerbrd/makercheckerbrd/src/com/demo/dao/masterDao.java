package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.User;
public class masterDao {

	private static int customerId = 0;
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(User U){
		int status=0;
		
		try{
			Connection con=getConnection();
			 customerId ++;
			PreparedStatement pre=con.prepareStatement("insert all into master_register values (customerId,customerCode,customerName,customerAddress1,customerAddress2,customerPinCode,emailaddress,contactNumber,primaryContactPerson,recordStatus,activeInactiveFlag,createDate,createBy,modifiedDate,modifiedBy,authorizedDate,authorizedBy) select * from temp_register"); 

			pre.setString(1,U.getCustomerCode() );
			pre.setString(2,U.getCustomerName() );
		      pre.setString(3, U.getCustomerAddress1());
		      pre.setString(4,U.getCustomerAddress2() );
		      pre.setInt(5,U.getCustomerPinCode());
		      pre.setString(6, U.getEmailaddress());
		      pre.setInt(7,U.getContactNumber() );
		      pre.setString(8,U.getPrimaryContactPerson() );
		      //String N= U.getRecordStatus();
		      pre.setString(9,"N");
		      pre.setString(10,U.getActiveInactiveFlag());
		      java.sql.Timestamp createDate= new java.sql.Timestamp(new java.util.Date().getTime());
		      pre.setTimestamp(11, createDate);
		      //pre.setDate(11,(java.sql.Date)  U.getCreateDate());
		 
		      pre.setString(12,U.getCreateBy());
		      java.sql.Timestamp modifiedDate= new java.sql.Timestamp(new java.util.Date().getTime());
		      pre.setTimestamp(13, modifiedDate);
		     // pre.setDate(13,(java.sql.Date)U.getModifiedDate() );
		      pre.setString(14,U.getModifiedBy());
		      java.sql.Timestamp authorizedDate= new java.sql.Timestamp(new java.util.Date().getTime());
		      pre.setTimestamp(15, authorizedDate);
		     // pre.setDate(15,(java.sql.Date) U.getAuthorizedDate() );
		      pre.setString(16,U.getAuthorizedBy());
			
			status=pre.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int update(User U){
		int status=0;
		
		try{
			Connection con=getConnection();
			 customerId ++;
			PreparedStatement pre=con.prepareStatement("update master_register set customerId=customerId ++ ,customerCode=?,customerName=?,customerAddress1=?,customerAddress2=?,customerPinCode=?,emailaddress=?,contactNumber=?,primaryContactPerson=?,recordStatus=?,activeInactiveFlag=?,createDate=?,createdBy=?,modifiedDate=?,modifiedBy=?,authorizedDate=?,authorizedBy=?  where customerCode=?");
			pre.setString(1,U.getCustomerCode() );
			pre.setString(2,U.getCustomerName() );
		      pre.setString(3, U.getCustomerAddress1());
		      pre.setString(4,U.getCustomerAddress2() );
		      pre.setInt(5,U.getCustomerPinCode());
		      pre.setString(6, U.getEmailaddress());
		      pre.setInt(7,U.getContactNumber() );
		      pre.setString(8,U.getPrimaryContactPerson() );
		      pre.setString(9,"M");
		      pre.setString(10,U.getActiveInactiveFlag() );
		      java.sql.Timestamp createDate= new java.sql.Timestamp(new java.util.Date().getTime());
		      pre.setTimestamp(11, createDate);
		//pre.setDate(11,(Date) U.getCreateDate());
		      pre.setString(12,U.getCreateBy());
		      java.sql.Timestamp modifiedDate= new java.sql.Timestamp(new java.util.Date().getTime());
		      pre.setTimestamp(13, modifiedDate);
		  //  pre.setDate(13,(Date) U.getModifiedDate() );
		      pre.setString(14,U. getModifiedBy());
		      java.sql.Timestamp authorizedDate= new java.sql.Timestamp(new java.util.Date().getTime());
		      pre.setTimestamp(15, authorizedDate);
		     // pre.setDate(15,(Date) U.getAuthorizedDate() );
		      pre.setString(16,U.getAuthorizedBy());
		      pre.setInt(17,U.getCustomerId());
			status=pre.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(User U){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("delete from master_register where customerCode=?");
			ps.setString(1,U.getCustomerCode());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}
	public static List<User> getAllRecords(){
		List<User> list=new ArrayList<User>();
		
		try{
			Connection con=getConnection();
			PreparedStatement pre=con.prepareStatement("select * from temp_register");
			ResultSet resultSet=pre.executeQuery();
			
			while(resultSet.next()){
				User U=new User();
				System.out.println(resultSet.getString( "customerCode" ));
				System.out.println(resultSet.getString( "customerName" ));
				System.out.println(resultSet.getString( "customerAddress1" ));
				System.out.println(resultSet.getString( "customerAddress2" ));
				System.out.println(resultSet.getString( "customerPinCode" ));
				System.out.println(resultSet.getString( "emailaddress" ));
				System.out.println(resultSet.getString( "contactNumber" ));
				System.out.println(resultSet.getString( "primaryContactPerson" ));
				System.out.println(resultSet.getString( "recordStatus" ));
				System.out.println(resultSet.getString( "activeInactiveFlag" ));
				System.out.println(resultSet.getString( "createDate" ));
				System.out.println(resultSet.getString( "createBy" ));
				System.out.println(resultSet.getString( "modifiedDate" ));
				System.out.println(resultSet.getString( "modifiedBy" ));
				System.out.println(resultSet.getString( "authorizedDate" ));
				System.out.println(resultSet.getString( "authorizedBY" ));
				
				
				U.setCustomerCode( resultSet.getString( "customerCode" )) ;
				U.setCustomerName( resultSet.getString( "customerName" )) ;
			
				U.setCustomerAddress1( resultSet.getString( "customerAddress1" )) ;
				U.setCustomerAddress2( resultSet.getString( "customerAddress2" )) ;
				U.setCustomerPinCode( resultSet.getInt( "customerPinCode" )) ;
				U.setEmailaddress( resultSet.getString( "emailaddress" )) ;
				U.setContactNumber( resultSet.getInt( "contactNumber" )) ;
				U.setPrimaryContactPerson( resultSet.getString( "primaryContactPerson" )) ;
				U.setRecordStatus( resultSet.getString( "recordStatus" )) ;
				U.setActiveInactiveFlag( resultSet.getString( "activeInactiveFlag" )) ;
				U.setCreateDate( resultSet.getDate( "createDate" )) ;
				U.setCreateBy( resultSet.getString( "createBy" )) ;
				
				U.setModifiedDate( resultSet.getDate( "modifiedDate" )) ;
				U.setModifiedBy( resultSet.getString( "modifiedBy" )) ;
				U.setAuthorizedDate( resultSet.getDate( "authorizedDate" )) ;
				U.setAuthorizedBy( resultSet.getString( "authorizedBY" )) ;
				U.setCustomerId( resultSet.getInt( "customerId" )) ;
				
				list.add(U);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static User getRecordById(String customerCode){
		User U=null;
		try{
			Connection con=getConnection();
			PreparedStatement pre=con.prepareStatement("select * from temp_register where customerCode=?");
			pre.setString(1,customerCode);
			ResultSet  resultSet=pre.executeQuery();
			while( resultSet.next()){
				U=new User();
				U.setCustomerCode( resultSet.getString( "customerCode" )) ;
				U.setCustomerName( resultSet.getString( "customerName" )) ;
				U.setCustomerAddress1( resultSet.getString( "customerAddress1" )) ;
				U.setCustomerAddress2( resultSet.getString( "customerAddress2" )) ;
				U.setCustomerPinCode( resultSet.getInt( "customerPinCode" )) ;
				U.setEmailaddress( resultSet.getString( "emailaddress" )) ;
				U.setContactNumber( resultSet.getInt( "contactNumber" )) ;
				U.setPrimaryContactPerson( resultSet.getString( "primaryContactPerson" )) ;
				U.setRecordStatus( resultSet.getString( "recordStatus" )) ;
				U.setActiveInactiveFlag( resultSet.getString( "activeInactiveFlag" )) ;
				U.setCreateDate( resultSet.getDate( "createDate" )) ;
				U.setCreateBy( resultSet.getString( "createBy" )) ;
				
				U.setModifiedDate( resultSet.getDate( "modifiedDate" )) ;
				U.setModifiedBy( resultSet.getString( "modifiedBy" )) ;
				U.setAuthorizedDate( resultSet.getDate( "authorizedDate" )) ;
				U.setAuthorizedBy( resultSet.getString( "authorizedBY" )) ;
			//	U.setCustomerId( resultSet.getInt( "customerId" )) ;
				
			}
		}catch(Exception e){System.out.println(e);}
		return U;
	}
}
