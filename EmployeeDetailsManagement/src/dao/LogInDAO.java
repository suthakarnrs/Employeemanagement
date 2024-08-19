package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionManager;
import model.LogIn;


public class LogInDAO {

	public boolean loginValidation(LogIn l) throws ClassNotFoundException, SQLException
	{
		String username = l.getUsername();
		String password = l.getPass();
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from adminLogIn");
		while(rs.next())
		{
			if(username.equals(rs.getString("name")) && password.equals(rs.getString("password")))
			{
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
	}
}
