package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.EventBean;
import DbConnection.connection;

public class EventAddDAO {

	Connection con = null;

	ResultSet rs = null;

	public String addEvent(Integer userId, EventBean eventBean)
			throws Exception {

		connection c = new connection();
		con = c.getConnection();
		String retVal = "failure";
		try {
			
			String query1 = "insert into `user-activity`(name, user_id) values (?,?)";
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1, eventBean.getName());
			preparedStmt1.setInt(2, userId);
			boolean status1 = preparedStmt1.execute();
			System.out.println(status1);
			
			System.out.println(eventBean.getEndDate());
			String query2 = "select id from `user-activity` where name = ? order by id desc limit 1";
			String query3 = "insert into `user-events`(id,venue, `start-date`, `end-date`, occurrence) values (?,?,?,?,?)";

			System.out.println("inserted value in activity table");
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setString(1, eventBean.getName());
			rs = preparedStmt2.executeQuery();

			while (rs.next()) {
				System.out.println("record found in activity table");
				int id = rs.getInt(1);
				PreparedStatement preparedStmt3 = con.prepareStatement(query3);
				preparedStmt3.setInt(1, id);
				preparedStmt3.setString(2, eventBean.getVenue());
				preparedStmt3.setString(3, eventBean.getStartDate());
				preparedStmt3.setString(4, eventBean.getEndDate());
				preparedStmt3.setString(5, eventBean.getOccurrence());
				boolean inserted = preparedStmt3.execute();
				System.out.println(inserted+"aaaaa");
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
