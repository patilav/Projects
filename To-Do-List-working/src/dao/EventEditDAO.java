package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbConnection.connection;

public class EventEditDAO {

	Connection con = null;

	ResultSet rs = null;

	public String editEvent(int id, String name, String venue,
			String startDate, String endDate, String occurence)
			throws Exception {

		connection c = new connection();
		con = c.getConnection();
		try {
			String query1 = "update `user-activity` set name = ? where id = ?";
			String query2 = "update `user-events` set venue = ?, `start-date` = ?, `end-date` = ?, occurrence = ? where id =? ";

			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1, name);
			preparedStmt1.setInt(2, id);
			int result1 = preparedStmt1.executeUpdate();

			if (result1 != 0) {
				PreparedStatement preparedStmt2 = con.prepareStatement(query2);
				preparedStmt2.setString(1, venue);
				preparedStmt2.setString(2, startDate);
				preparedStmt2.setString(3, endDate);
				preparedStmt2.setString(4, occurence);
				preparedStmt2.setInt(5, id);
				preparedStmt2.executeUpdate();
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

	public String deleteEvent(int id) throws Exception {

		connection c = new connection();
		con = c.getConnection();
		String status = "fail"; 
		try {
			String query1 = "delete from `user-activity` where id = ?";
			String query2 = "delete from `user-events` where id =? ";

			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setInt(1, id);

			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setInt(1, id);
			preparedStmt2.executeUpdate();
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
