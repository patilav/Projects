package dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.connection;

public class NotesEditDAO {

	Connection con = null;

	ResultSet rs = null;

	public String editNotes(int id, String name, String text, File filePath)
			throws Exception {

		FileInputStream fin = new FileInputStream(filePath);
		connection c = new connection();
		con = c.getConnection();
		try {
			String query1 = "update `user-activity` set name = ? where id = ?";
			String query2 = "update `user-notes` set text = ? where id = ? ";
			String query3 = "update `user-notes-images` set image = ? where id = ?";

			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1, name);
			preparedStmt1.setInt(2, id);
			int result1 = preparedStmt1.executeUpdate();

			if (result1 != 0) {
				PreparedStatement preparedStmt2 = con.prepareStatement(query2);
				PreparedStatement preparedStmt3 = con.prepareStatement(query3);

				preparedStmt2.setString(1, text);
				preparedStmt2.setInt(2, id);
				preparedStmt2.executeUpdate();

				preparedStmt3.setBinaryStream(1, fin, (int) filePath.length());
				preparedStmt3.setInt(2, id);
				preparedStmt3.executeUpdate();
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		} finally {
			con.commit();
			con.close();
		}
		return "fail";
	}

}
