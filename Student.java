package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student 
{
	Scanner sc = new Scanner(System.in);
	Connection con = DBConnection.getCon();
	

	public void register()
	{
		System.out.println("User_Id :");
		int user_id =sc.nextInt();
		System.out.println("User_name :");
		String User_name =sc.nextLine();
		sc.nextLine();
		System.out.println("Name : ");
		String name =sc.nextLine();
		System.out.println("Email : ");
		String email =sc.nextLine();
		System.out.println("Password : ");
		String pass =sc.nextLine();
		
		if(user_exist(user_id))
		{
			System.out.println("User Already Exists for this User_Id ||");
        	return;
		}
		
		try {
			PreparedStatement ps = 
					con.prepareStatement("insert into stud values(?,?,?,?,?)");
           
            ps.setInt(1, user_id);
            ps.setString(2, User_name);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, pass);
            
            int k = ps.executeUpdate();
            if(k > 0) 
            {
            	System.out.println("Registration Successfull!");
            } else 
            {
                System.out.println("Registration Failed!");
           
            }
		} 
		catch (Exception e) 
	    {
			e.printStackTrace();
		}
		
	}
	
	
	public int login()
	{
			System.out.println("User_id :");
			int user_id = sc.nextInt();
			System.out.println("Password :");
			String pass = sc.nextLine();
			sc.nextLine();
			
			try {
				PreparedStatement ps = 
							con.prepareStatement("select * from stud where User_id =? and password=?");
					ps.setInt(1, user_id);
					ps.setString(2, pass);
					
					ResultSet rs= ps.executeQuery();
					if (rs.next()) 
					{
						return user_id;//System.out.println(user_id);
						
					}
					else {
						return 0; //System.out.println("Invalid username or password. Please try again.");
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return 0;
	}
	
	public boolean user_exist(int user_id) 
	{
		 try 
		 {
			 PreparedStatement ps = 
						con.prepareStatement("select * from stud where User_id =?");
			 ps.setInt(1, user_id);
			 ResultSet rs= ps.executeQuery();
			 if (rs.next()) 
			 {
				 return true;
			 }
			 else 
			 {
				 return false;
			 }
		 }
		 catch(Exception e) 
		 {
			 e.printStackTrace();
		 }
		 return false;
	}

}
