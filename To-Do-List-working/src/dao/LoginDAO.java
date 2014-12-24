package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.LoginBean;
import DbConnection.*;

public class LoginDAO {

	Connection con = null;
	ResultSet rs = null;

	public LoginBean validateLogin(String username, String password) {

		connection c = new connection();
		con = c.getConnection();
		LoginBean loginBean = new LoginBean();
		try {
			String query = "select * from user where username = ? and password = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);
			loginBean.setUsername(username);
			rs = preparedStmt.executeQuery();
			if(rs.next()) {
				loginBean.setId(rs.getInt("id"));
				loginBean.setValidated(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginBean;
	}
}
