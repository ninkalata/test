
/*
 * Classname:FileUpload
*
 * Version info:0.01
 *
 * Copyright notice
 */package com.demo.training1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;


	public class FileUpload {
	private static BufferedReader reader;
	private static int customerId = 0;
	public static void main(InputStream fileContent, String fileName,String flevel) throws IOException, SQLException {
	String   CustomerCode,  CustomerName,  CustomerAddress1, CustomerAddress2, CustomerPinCode, Emailaddress, ContactNumber, PrimaryContactPerson, RecordStatus, ActiveInactiveFlag,   CreateDate,  CreatedBy, ModifiedDate,  ModifiedBy, AuthorizedDate, AuthorizedBy ;
	try {
		//check the file will be in .txt format or not
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
	if (fileName.endsWith(".txt")) {
	System.out.println("Correct");
	
	String l;
				//spliting ~sysmbol from each fields
				while ((l = reader.readLine()) != null) {
					l += "~";
				String[] lines = l.split("(?<=~)");
	for (int ctr = 0; ctr < lines.length; ctr++) {
						while (lines[ctr].length() >= 1 && lines[ctr].charAt(lines[ctr].length() - 1) == '~') {
							lines[ctr] =lines[ctr].substring(0,lines[ctr].length() - 1);
						}
					}
				for(String line:lines) {
			System.out.println(line);
				}
				//storing each field in database
				CustomerName=lines[1];
				Emailaddress=lines[5];
				CustomerPinCode=lines[4];
				RecordStatus=lines[8];
				ActiveInactiveFlag=lines[9];
				CustomerAddress1=lines[2];
				CustomerAddress2=lines[3];
				ContactNumber=lines[6];
				PrimaryContactPerson=lines[7];
				CreateDate=lines[10];
				CreatedBy=lines[11];
				ModifiedDate=lines[12];
				ModifiedBy=lines[13];
			    AuthorizedDate=lines[14];
				AuthorizedBy=lines[15];
				CustomerCode=lines[0];
				// file level validation
				
		     //record level validation
				if(flevel.equals("recordlevel"))
				{
				 if( checker(lines)==true) {
					 try {
					 customerId++;
          //System.out.println(checker(lines));
				Javaconnection.insertFile( customerId, CustomerCode, CustomerName,  CustomerAddress1, CustomerAddress2, CustomerPinCode, Emailaddress, ContactNumber,PrimaryContactPerson, RecordStatus, ActiveInactiveFlag, CreateDate, CreatedBy,ModifiedDate, ModifiedBy, AuthorizedDate,AuthorizedBy);
								}
					 catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
// 				 else if(checker(lines)==false){
//					System.exit(0);
//			 }
				}
					 for(String line:lines) {
							System.out.println(line);
								}
				 }
				
					 
					 else {
							System.out.println("");
						}
				}
			
					 
			//FILEVALIDAT
				if(flevel.equals("filelevel"))
				{
				if( checker(lines)==true) {
					 try {
					 customerId++;
         //System.out.println(checker(lines));
				Javaconnection.insertFile( customerId, CustomerCode, CustomerName,  CustomerAddress1, CustomerAddress2, CustomerPinCode, Emailaddress, ContactNumber,PrimaryContactPerson, RecordStatus, ActiveInactiveFlag, CreateDate, CreatedBy,ModifiedDate, ModifiedBy, AuthorizedDate,AuthorizedBy);
								}
					 catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
//				 else if(checker(lines)==false){
//					System.exit(0);
//			 }
				}
				
				}
				
					 
				
	else {
			System.out.println("Invalid");
		 }
	}
	}
	}
	}
	catch(FileNotFoundException exception) {
		 System.out.println(exception);
		}	
	}
	
       //Customer name validation
		public static boolean  customerName(String lines) {
				 		  Pattern p= Pattern.compile(("^[a-zA-Z\\s]*$"));
				 		  if(p.matcher(lines).find()) {
				 			  return true;
				 		  }
				 		  return false;
				 	  }
		//pinCode validation
				 	 public static boolean customerPinCode(String lines){
				 		 if(lines.length()<=6){
				 			 return true;
				 			 }
				 		 return false;
				 	 }
				// E mail address validationa
				 	public static boolean e_mailaddress(String lines){
				 		Pattern p= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	                    if(p.matcher(lines).find()){
	                      return true;
				 		  }
				 		  return false;
	                     }
	              //record status validation
				 	public static boolean recordStatus(String lines){ 
				 		 if(lines.equals("N") || lines.equals("M")||lines.equals("D")||lines.equals("A")||lines.equals("R")){
				return true;		
				}
			 	return false;
				 	}

            // active and inactive flag validation
				 	public static boolean isFlag(String lines) {
			 	 if(lines.equals("A") || lines.equals("I")){
					return true;
				}
				return false;
			 	}
			 	// checking all validation
			 	public static boolean checker(String[] lines){
				 		if(customerName(lines[1])&& e_mailaddress(lines[5])&& customerPinCode(lines[4]) && recordStatus(lines[8])&&isFlag(lines[9])){
				 	return true;
				 	}
			 		return false;
			 	}
	}
			 	
			 	

	


