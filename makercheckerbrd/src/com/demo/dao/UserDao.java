package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.demo.model.User;

public class UserDao {

	private static int customerId = 0;

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(User U) {
		int status = 0;

		try {
			Connection con = UserDao.getConnection();
			// customerId++;
			PreparedStatement pre = con.prepareStatement(
					"insert into temp_register(customerId,customerCode,customerName,customerAddress1,customerAddress2,customerPinCode,emailaddress,contactNumber,primaryContactPerson,recordStatus,activeInactiveFlag,createDate,createBy,modifiedDate,modifiedBy,authorizedDate,authorizedBy) values('"
							+ customerId++ + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pre.setString(1, U.getCustomerCode());
			pre.setString(2, U.getCustomerName());
			pre.setString(3, U.getCustomerAddress1());
			pre.setString(4, U.getCustomerAddress2());
			pre.setInt(5, U.getCustomerPinCode());
			pre.setString(6, U.getEmailaddress());
			pre.setInt(7, U.getContactNumber());
			pre.setString(8, U.getPrimaryContactPerson());
			pre.setString(9, "N");
			pre.setString(10, U.getActiveInactiveFlag());
			java.sql.Timestamp createDate = new java.sql.Timestamp(new java.util.Date().getTime());
			pre.setTimestamp(11, createDate);
			pre.setString(12, U.getCreateBy());
			java.sql.Timestamp modifiedDate = new java.sql.Timestamp(new java.util.Date().getTime());
			pre.setTimestamp(13, modifiedDate);
			pre.setString(14, U.getModifiedBy());
			java.sql.Timestamp authorizedDate = new java.sql.Timestamp(new java.util.Date().getTime());
			pre.setTimestamp(15, authorizedDate);
			pre.setString(16, U.getAuthorizedBy());
			status = pre.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(User U) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			// String customercode=(String) request.getSession(false).getAttribute("code");

			// System.out.println(customercode);

			PreparedStatement pre = con.prepareStatement(
					"update  temp_register set customerCode=? where customerCode=?");
			pre.setString(1, U.getCustomerCode());
			pre.setString(2, U.getCustomerCode());
			System.out.println(U.getCustomerCode());
			con.close();
			System.out.println("connectionclosed");
			
			System.exit(0);

			/*pre.setString(2, U.getCustomerName());
			pre.setString(3, U.getCustomerAddress1());
			pre.setString(4, U.getCustomerAddress2());
			pre.setInt(5, U.getCustomerPinCode());
			pre.setString(6, U.getEmailaddress());
			pre.setInt(7, U.getContactNumber());
			pre.setString(8, U.getPrimaryContactPerson());
			pre.setString(9, "M");
			pre.setString(10, U.getActiveInactiveFlag());
			java.sql.Timestamp createDate = new java.sql.Timestamp(new java.util.Date().getTime());
			pre.setTimestamp(11, createDate);
			pre.setString(12, U.getCreateBy());
			java.sql.Timestamp modifiedDate = new java.sql.Timestamp(new java.util.Date().getTime());
			pre.setTimestamp(13, modifiedDate);
			pre.setString(14, U.getModifiedBy());
			java.sql.Timestamp authorizedDate = new java.sql.Timestamp(new java.util.Date().getTime());
			pre.setTimestamp(15, authorizedDate);
			pre.setString(16, U.getAuthorizedBy());
			pre.setString(17, U.getCustomerCode());*/

			status = pre.executeUpdate();
			System.out.println(status);
			con.close();
		} catch (Exception e) {
			System.out.println("Exception="+e);
		}
		return status;
	}

	public static int delete(User U) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from temp_register where customerCode=?");
			ps.setString(1, U.getCustomerCode());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<User> getAllRecords() {
		List<User> list = new ArrayList<User>();

		try {
			Connection con = UserDao.getConnection();
			PreparedStatement pre = con.prepareStatement("select * from temp_register");
			ResultSet resultSet = pre.executeQuery();

			while (resultSet.next()) {
				User U = new User();

				U.setCustomerCode(resultSet.getString("customerCode"));
				U.setCustomerName(resultSet.getString("customerName"));
				U.setCustomerAddress1(resultSet.getString("customerAddress1"));
				U.setCustomerAddress2(resultSet.getString("customerAddress2"));
				U.setCustomerPinCode(resultSet.getInt("customerPinCode"));
				U.setEmailaddress(resultSet.getString("emailaddress"));
				U.setContactNumber(resultSet.getInt("contactNumber"));
				U.setPrimaryContactPerson(resultSet.getString("primaryContactPerson"));
				U.setRecordStatus(resultSet.getString("recordStatus"));
				U.setActiveInactiveFlag(resultSet.getString("activeInactiveFlag"));
				U.setCreateDate(resultSet.getDate("createDate"));
				U.setCreateBy(resultSet.getString("createBy"));
				U.setModifiedDate(resultSet.getDate("modifiedDate"));
				U.setModifiedBy(resultSet.getString("modifiedBy"));
				U.setAuthorizedDate(resultSet.getDate("authorizedDate"));
				U.setAuthorizedBy(resultSet.getString("authorizedBY"));
				U.setCustomerId(resultSet.getInt("customerId"));

				list.add(U);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static User getRecordById(String customerCode) {
		User U = new User();
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement pre = con.prepareStatement("select * from temp_register where customerCode=?");
			pre.setString(1, customerCode);
			ResultSet resultSet = pre.executeQuery();
			while (resultSet.next()) {

				System.out.println(resultSet.getString("customerCode"));
				System.out.println(resultSet.getString("customerName"));
				System.out.println(resultSet.getString("customerAddress1"));
				System.out.println(resultSet.getString("customerAddress2"));
				System.out.println(resultSet.getString("customerPinCode"));
				System.out.println(resultSet.getString("emailaddress"));
				System.out.println(resultSet.getString("contactNumber"));
				System.out.println(resultSet.getString("primaryContactPerson"));
				System.out.println(resultSet.getString("recordStatus"));
				System.out.println(resultSet.getString("activeInactiveFlag"));
				System.out.println(resultSet.getString("createDate"));
				System.out.println(resultSet.getString("createBy"));
				System.out.println(resultSet.getString("modifiedDate"));
				System.out.println(resultSet.getString("modifiedBy"));
				System.out.println(resultSet.getString("authorizedDate"));
				System.out.println(resultSet.getString("authorizedBY"));

				U.setCustomerCode(resultSet.getString("customerCode"));
				U.setCustomerName(resultSet.getString("customerName"));
				U.setCustomerAddress1(resultSet.getString("customerAddress1"));
				U.setCustomerAddress2(resultSet.getString("customerAddress2"));
				U.setCustomerPinCode(resultSet.getInt("customerPinCode"));
				U.setEmailaddress(resultSet.getString("emailaddress"));
				U.setContactNumber(resultSet.getInt("contactNumber"));
				U.setPrimaryContactPerson(resultSet.getString("primaryContactPerson"));
				U.setRecordStatus(resultSet.getString("recordStatus"));
				U.setActiveInactiveFlag(resultSet.getString("activeInactiveFlag"));
				U.setCreateDate(resultSet.getDate("createDate"));
				U.setCreateBy(resultSet.getString("createBy"));
				U.setModifiedDate(resultSet.getDate("modifiedDate"));
				U.setModifiedBy(resultSet.getString("modifiedBy"));
				U.setAuthorizedDate(resultSet.getDate("authorizedDate"));
				U.setAuthorizedBy(resultSet.getString("authorizedBY"));
				U.setCustomerId(resultSet.getInt("customerId"));

			}
		} catch (Exception e) {
			System.out.println("Exeption="+e);
		}
		return U;
	}
}
