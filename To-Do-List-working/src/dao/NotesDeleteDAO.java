package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.connection;

public class NotesDeleteDAO {
	
	Connection con = null;

	ResultSet rs = null;
	public String deleteNotes(int id) throws Exception {

		connection c = new connection();
		con = c.getConnection();
		String status = "fail"; 
		try {
			String query1 = "delete from `user-activity` where id = ?";
			String query2 = "delete from `user-notes` where id =? ";
			String query3 = "delete from `user-notes-images` where id=?";

			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setInt(1, id);
			preparedStmt1.executeUpdate();

			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setInt(1, id);
			preparedStmt2.executeUpdate();
			
			PreparedStatement preparedStmt3 = con.prepareStatement(query3);
			preparedStmt3.setInt(1, id);
			preparedStmt3.executeUpdate();
			status= "success";

		} catch (SQLException e) {
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
