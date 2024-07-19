package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StartExam 
{
	Scanner sc = new Scanner(System.in);
	Connection con = DBConnection.getCon();
	
	public void startExam()
	{
		try
		{
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery("Select * from Questions");
		int totalQues = 0;
		int score = 0;
		while(rs.next())
		{
			totalQues++;
			System.out.println("your exam start....");
			
			int quesid = rs.getInt("ques_id");
			String quesText = rs.getString("question");
			String opt1 = rs.getString("option_a");
			String opt2 = rs.getString("option_b");
			String opt3 = rs.getString("option_c");
			String opt4 = rs.getString("option_d");
			int correctopt = rs.getInt("correct_option");
			
			System.out.println("Question "+quesid +":"+quesText);
			System.out.println("Options : ");
			System.out.println("1. " + opt1);
            System.out.println("2. " + opt2);
            System.out.println("3. " + opt3);
            System.out.println("4. " + opt4);
            System.out.println();
            System.out.println("Enter your answer (1-4) : ");
            int selectans =sc.nextInt();
            
            if(selectans == correctopt ) {
            	score++;
            }
		}
		System.out.println("Exam Completed :");
		System.out.println("Total Question :"+totalQues);
		System.out.println("Score : "+score);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
			

}
