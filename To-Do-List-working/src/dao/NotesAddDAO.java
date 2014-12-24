package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import bean.NotesBean;
import DbConnection.connection;

public class NotesAddDAO {

	Connection con = null;

	ResultSet rs = null;

	public String addNotes(Integer userId, NotesBean notesBean, File filePath)
			throws Exception {

		connection c = new connection();
		con = c.getConnection();
		String retVal = "failure";
		 FileInputStream fin = new FileInputStream(filePath);
		try {
				
			String query1 = "insert into `user-activity`(name, user_id) values (?,?)";
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1,notesBean.getName());
			preparedStmt1.setInt(2, userId);
			boolean status1 = preparedStmt1.execute();
			System.out.println(status1);
			
			String query2 = "select id from `user-activity` where name = ? order by id desc limit 1";
			String query3 = "insert into `user-notes`(id, text) values (?,?)";
			String query4 = "insert into `user-notes-images` (id, image) values (?,?)";
			
			
			System.out.println("inserted value in activity table");
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setString(1, notesBean.getName());
			rs = preparedStmt2.executeQuery();

			while (rs.next()) {
				System.out.println("record found in activity table");
				int id = rs.getInt(1);
				PreparedStatement preparedStmt3 = con.prepareStatement(query3);
				preparedStmt3.setInt(1, id);
				preparedStmt3.setString(2, notesBean.getText());
				boolean inserted = preparedStmt3.execute();
				
				System.out.println("here");
				PreparedStatement preparedStmt4 = con.prepareStatement(query4);
				preparedStmt4.setInt(1, id);
				preparedStmt4.setBinaryStream(2, fin, (int)filePath.length());
				int inserted_image = preparedStmt4.executeUpdate();
				System.out.println(inserted);
				if (inserted == false)
					retVal = "success";
			}

			
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			con.commit();
			con.close();
		}
		return retVal;
	}
}
