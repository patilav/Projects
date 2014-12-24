package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AppointmentBean;
import bean.EventBean;

import DbConnection.connection;

public class AppointmentViewDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<AppointmentBean> view(int id) throws SQLException {
		AppointmentBean ab;
		List<AppointmentBean> la = new ArrayList<AppointmentBean>();
		connection c = new connection();
		con = c.getConnection();
		try {
			System.out.println("The login ID is :" + id);
			String query1 = "select a.id, a.name, ap.`date-of-appointment`, ap.purpose, ap.location, ap.duration, ap.priority from `user-activity` a, `user-appointments` ap where a.id = ap.id and a.user_id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ab = new AppointmentBean();
				ab.setAppointmentId(rs.getInt(1));
				ab.setName(rs.getString(2));
				ab.setDateOfAppointment(rs.getString(3));
				ab.setPurpose(rs.getString(4));
				ab.setLocation(rs.getString(5));
				ab.setDuration(rs.getInt(6));
				ab.setPriority(rs.getString(7));
				la.add(ab);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return la;
	}

	
	public AppointmentBean getAppointmentForEdit(int eventBeanId) throws SQLException {
		AppointmentBean ab = new AppointmentBean();
		connection c = new connection();
		con = c.getConnection();
		try {
			System.out.println("id before the query:"+eventBeanId);
			String query1 = "select a.id, a.name, ap.`date-of-appointment`, ap.purpose, ap.location, ap.duration, ap.priority from `user-activity` a, `user-appointments` ap where a.id = ap.id and a.id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, eventBeanId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ab = new AppointmentBean();
				
				ab.setAppointmentId(rs.getInt(1));
				ab.setName(rs.getString(2));
				ab.setDateOfAppointment(rs.getString(3));
				ab.setPurpose(rs.getString(4));
				ab.setLocation(rs.getString(5));
				ab.setDuration(rs.getInt(6));
				ab.setPriority(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return ab;
	}


	
	public List<AppointmentBean> getAppointmentInfo(int eventBeanId) throws SQLException {
		AppointmentBean ab = new AppointmentBean();
		List<AppointmentBean> li = new ArrayList<AppointmentBean>();
		
		connection c = new connection();
		con = c.getConnection();
		try {
			String query1 = "select a.id, a.name, ap.`date-of-appointment`, ap.purpose, ap.location, ap.duration, ap.priority from `user-activity` a, `user-appointments` ap where a.id = ap.id and a.user_id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, eventBeanId);
			rs = ps.executeQuery();
			while (rs.next()) {
				ab = new AppointmentBean();
				ab.setAppointmentId(rs.getInt(1));
				ab.setName(rs.getString(2));
				ab.setDateOfAppointment(rs.getString(3));
				ab.setPurpose(rs.getString(4));
				ab.setLocation(rs.getString(5));
				ab.setDuration(rs.getInt(6));
				ab.setPriority(rs.getString(7));
				li.add(ab);
		 }
			
			System.out.println("li here ->"+li);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return li;
	}
}
