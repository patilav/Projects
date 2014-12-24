package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AppointmentBean;


import DbConnection.connection;

public class AppointmentAddDAO {

	Connection con = null;

	ResultSet rs = null;

	public String addAppointment(Integer userId, AppointmentBean appointmentBean)
			throws Exception {

		connection c = new connection();
		con = c.getConnection();
		String retVal = "failure";
		
		try {
			
			String query1 = "insert into `user-activity`(name, user_id) values (?,?)";
			PreparedStatement preparedStmt1 = con.prepareStatement(query1);
			preparedStmt1.setString(1, appointmentBean.getName());
			preparedStmt1.setInt(2, userId);
			boolean status1 = preparedStmt1.execute();
			System.out.println(status1);
			String query2 = "select id from `user-activity` where name = ? order by id desc limit 1";
			String query3 = "insert into `user-appointments`(id,`date-of-appointment`,purpose,location,duration,priority) values (?,?,?,?,?,?)";
			System.out.println("inserted value in activity table");
			PreparedStatement preparedStmt2 = con.prepareStatement(query2);
			preparedStmt2.setString(1, appointmentBean.getName());
			rs = preparedStmt2.executeQuery();
			System.out.println("here"+appointmentBean.getDateOfAppointment());
			while (rs.next()) {
				System.out.println("record found in activity table");
				int id = rs.getInt(1);
				PreparedStatement preparedStmt3 = con.prepareStatement(query3);
				preparedStmt3.setInt(1, id);
				preparedStmt3.setString(2, appointmentBean.getDateOfAppointment());
				preparedStmt3.setString(3, appointmentBean.getPurpose());
				preparedStmt3.setString(4, appointmentBean.getLocation());
				preparedStmt3.setInt(5, appointmentBean.getDuration());
				preparedStmt3.setString(6, appointmentBean.getPriority());
				boolean inserted = preparedStmt3.execute();
				if (inserted == true)
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
