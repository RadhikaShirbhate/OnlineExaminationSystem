package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateProfile 
{
	Scanner sc=new Scanner(System.in);
	Connection con = DBConnection.getCon();
	
//	public void UpdateProfile(int user_id) {
//		
//		while(true)
//		{
//			System.out.println("what you want to update profile or password ?");
//			System.out.println("1. Profile");
//			System.out.println("2. Password");
//			System.out.println("Enter your choice  :-");
//			
//			int choice = sc.nextInt();
//			switch(choice)
//			{
//			case 1:
//				
//				try {
//					Statement st = con.createStatement();
//					ResultSet rs = st.executeQuery("select * from stud where user_id = ?");
//					
//					if(rs.next())
//					{
//						user_id=rs.getInt("user_id");
//						System.out.println("Enter your new name : ");
//						String newname = sc.nextLine();
//						System.out.println("Enter your new email : ");
//						String newemail = sc.nextLine();
//						
//						PreparedStatement pst = con.prepareStatement("update stud set name=? , email=? where user_id=?");
//						pst.setString(1, newname);
//						pst.setString(2, newemail);
//						pst.setInt(3, user_id);
//						
//						pst.executeUpdate();
//						System.out.println("Profile information updated successfully!");
//					}
//				}
//				catch(Exception e) {
//				}
//				break;
//				
//			case 2:
//				
//			default: 
//				System.out.println("Invalid choice...");
//			}
//			
//		}
//		
//	}
//	
	
	
	
	public void update()
	{
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your user_id : ");
			int user_id = sc.nextInt();
			Statement st = con.createStatement();
	        //ResultSet rs = st.executeQuery("select * from stud where user_id = ?");
			
//			if(rs.next())
//			{
//				 user_id = rs.getInt("id");
//				String user_name = rs.getString("user_name");
//				String name = rs.getString("name");
//				String email = rs.getString("mail");
//				String pass = rs.getString("pass");
//				
//				System.out.println("Current profile Information : ");
//				System.out.println("User_id : "+ user_id);
//				System.out.println("Username : "+ user_name);
//				System.out.println("Name : "+name);
//				System.out.println("E-mail : "+email);
//				System.out.println("Password : "+pass); 
//				
//			
//			}
		System.out.println("Do you want to update your profile or password? (profile/password/no)");
        String choice1 = sc.nextLine().toLowerCase();
        
        
        if (choice1.equals("profile"))
        {
        	System.out.println("Enter your new name : ");
			String newname = sc.nextLine();
			System.out.println("Enter your new email : ");
			String newemail = sc.nextLine();
			
			PreparedStatement pst = con.prepareStatement("update stud set name=? , email=? where user_id=?");
			pst.setString(1, newname);
			pst.setString(2, newemail);
			pst.setInt(3, user_id);
			
			pst.executeUpdate();
			System.out.println("Profile information updated successfully!");
        
        }
        else if(choice1.equals("password"))
        {
        	System.out.println("Enter your new Password :");
        	String newpass = sc.nextLine();
        	
        	PreparedStatement pst = con.prepareStatement("update stud set pass=? where user_id=?");
        	pst.setString(1, newpass);
        	pst.setInt(2, user_id);
        	
        	pst.executeUpdate();
        	System.out.println("Password update successfully....");
        }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
