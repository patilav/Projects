package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.connection;
import bean.LoginBean;

public class ForgotPasswordDAO {
	
	
	Connection con = null;
	ResultSet rs = null;

	public String forgotPassword(String username) {

		connection c = new connection();
		con = c.getConnection();
		LoginBean loginBean = new LoginBean();
		String question = null;
		try {
			String query = "select secretquestion from user where username = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, username);
			loginBean.setUsername(username);
			rs = preparedStmt.executeQuery();
			if(rs.next()) {
				//loginBean.setSecret_question(rs.getString(1));
				
				question = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(question);
		return question;
	}
	
 public String setNewPassword(String username, String secretAnswer)
{
	 connection c = new connection();
	 con = c.getConnection();
	 String status = null;
	 try{
		 String query1 = "select secretanswer from user where username=?";
		 PreparedStatement preparedStmt1 = con.prepareStatement(query1);
		 preparedStmt1.setString(1, username);
		 rs = preparedStmt1.executeQuery();
		 
		 while(rs.next())
		 {
			 if(secretAnswer.equals(rs.getString(1)))
				 status = "done";
			 else 
				 status = "not done";
		 }
		 
	 }
	 
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 
	 }

	 return status;
}
 
 
 	public String changePassword(String password, String username) throws Exception
 	{
 		connection c = new connection();
 		 con = c.getConnection();
 		 String status = null;
 		 try{
 			 System.out.println(username +"->"+password);
 			 String query1 = "update user set password = ? where username = ?";
 			 PreparedStatement preparedStmt1 = con.prepareStatement(query1);
 			 preparedStmt1.setString(1, password);
 			 preparedStmt1.setString(2, username);
 			 int result = preparedStmt1.executeUpdate();
 			 System.out.println("result"+result);
 			 if(result != 0)
 			 {
 				 status = "done";
 			 }
 			 else
 				 status = "not done";
 		 }
 		 
 		catch(Exception e)
 		{
 			e.printStackTrace();
 		}
 		 
 		finally {
			con.commit();
			con.close();
		}
 		 return status;
 	}
 
}



