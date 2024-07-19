package Test;

import java.util.Scanner;
import Test.Student;
import Test.UpdateProfile;

public class ExamMain
{
	public static void main(String[] args) 
	{
		int user_id;
		Scanner sc = new Scanner(System.in);
		Student st = new Student();
		UpdateProfile up = new UpdateProfile();
		StartExam se = new StartExam();
		try 
		{
			while(true)
			{
				System.out.println();
				System.out.println("*******WELCOME TO ONLINE EXAMINATION*******");
				System.out.println( );
		        
		        System.out.println("1. Login");
		        System.out.println("2. Register");
		        System.out.println("Enter Your Choice :");
		        
		        int choice=sc.nextInt();
		        
		        switch(choice)
		        {
		        case 1: 
		        	user_id = st.login();
		        	System.out.println("Login Succesfully.....");
		        	System.out.println();
		        	
		        	System.out.println("1. Update Profile and password");
					System.out.println("2. Start Exam");
					System.out.println("3. Logout");
					System.out.println("Enter your choice : ");
					int choice1 = sc.nextInt();
					
					switch(choice1)
					{
					case 1:
						up.update();
						break;
						
					case 2:
						se.startExam();
						break;
						
					case 3:
						System.out.println("Logout successfully.....");
						break;
						
					default:
							
						System.out.println("Invalid Choice.....");
						break;
					}
					break;
					
		        case 2:
		        	st.register();
		        	break;
		        	
		        default: 
		        		System.out.println("Invalid Choice.....");
		        		break;
		        }
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	
	}
			
}
