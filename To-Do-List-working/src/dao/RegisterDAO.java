package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DbConnection.connection;

public class RegisterDAO {

	Connection con = null;
	ResultSet rs = null;

	public boolean registerCustomer(String fname, String lname,
			String username, String password, String dob,
			String secretquestion, String secretanswer, String homephone,
			String workphone, String mobilephone) throws Exception {

		connection c = new connection();
		con = c.getConnection();
		int insertCount=0;
		boolean status = false;
		try {
			String query = "insert into user(username, password, firstname, lastname, dateofbirth, secretquestion, secretanswer)"
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, fname);
			preparedStmt.setString(4, lname);
			preparedStmt.setString(5, dob);
			preparedStmt.setString(6, secretquestion);
			preparedStmt.setString(7, secretanswer);
			insertCount = preparedStmt.executeUpdate();
			if(insertCount == 1){
				status = true;
			}
			
			String query2 = "select id from `user` where username = ? order by id desc limit 1";
			String query3 = "insert into `userphone`(id, phone) values (?,?)";

			
			System.out.println("inserted value in user table");
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setString(1, username);
			rs = preparedStmt2.executeQuery();
			
			while (rs.next()) {
				System.out.println("record found in user table");
				int id = rs.getInt(1);
				
				if (homephone.length() != 0) {
					PreparedStatement preparedStmt3 = con.prepareStatement(query3);
					preparedStmt3.setInt(1, id);
					preparedStmt3.setString(2, homephone);
					System.out.println(preparedStmt3.toString());
					boolean inserted = preparedStmt3.execute();
					System.out.println("Status of home phone insert here is" + inserted);
				}
				if (workphone.length() != 0) {
					PreparedStatement preparedStmt4 = con.prepareStatement(query3);
					preparedStmt4.setInt(1, id);
					preparedStmt4.setString(2, workphone);
					System.out.println(preparedStmt4.toString());
					boolean inserted = preparedStmt4.execute();
					System.out.println("Status of work phone insert here is" + inserted);
				}
				if (mobilephone.length() != 0) {
					PreparedStatement preparedStmt5 = con.prepareStatement(query3);
					preparedStmt5.setInt(1, id);
					preparedStmt5.setString(2, mobilephone);
					System.out.println(preparedStmt5.toString());
					boolean inserted = preparedStmt5.execute();
					System.out.println("Status of mobile phone insert here is" + inserted);
				}
			}
		} catch (SQLException e) {
			System.out.println("Found an error");
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			con.commit();
			con.close();
		}
		return status;
	}
}
