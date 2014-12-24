package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EventBean;

import DbConnection.connection;

public class EventViewDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<EventBean> view(int id) throws SQLException {
		EventBean eb;
		List<EventBean> le = new ArrayList<EventBean>();
		connection c = new connection();
		con = c.getConnection();
		try {
			System.out.println("The login ID is :" + id);
			String query1 = "select a.id, a.name, e.venue, e.`start-date`, e.`end-date`, e.occurrence from `user-activity` a, `user-events` e where a.id = e.id and a.user_id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				eb = new EventBean();
				eb.setEventId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setVenue(rs.getString(3));
				eb.setStartDate(rs.getString(4));
				eb.setEndDate(rs.getString(5));
				eb.setOccurrence(rs.getString(6));
				le.add(eb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return le;
	}

	public EventBean getEventInfo(int eventBeanId) throws SQLException {
		EventBean eb = new EventBean();
		connection c = new connection();
		con = c.getConnection();
		try {
			String query1 = "select a.id, a.name, e.venue, e.`start-date`, e.`end-date`, e.occurrence from `user-activity` a, `user-events` e where a.id = e.id and a.id = ?";
			ps = con.prepareStatement(query1);
			ps.setInt(1, eventBeanId);
			rs = ps.executeQuery();
			while (rs.next()) {
				eb = new EventBean();
				eb.setEventId(rs.getInt(1));
				eb.setName(rs.getString(2));
				eb.setVenue(rs.getString(3));
				eb.setStartDate(rs.getString(4));
				eb.setEndDate(rs.getString(5));
				eb.setOccurrence(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			con.close();
		}
		return eb;
	}
}
