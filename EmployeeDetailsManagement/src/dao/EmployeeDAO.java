package dao;

import java.sql.*;

import Connection.ConnectionManager;
import model.EmployeeDetails;


public class EmployeeDAO {

	public  static void addEmployee(EmployeeDetails p) throws ClassNotFoundException, SQLException
	{
		int empId = p.getEmpId();
		String name = p.getName();
		String email = p.getEmail();
		String phone = p.getPhone();
		String role = p.getDeprole();
		int salary = p.getSalary();
		
		
		
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		String query = "insert into employee values (?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,empId);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, phone);
		ps.setString(5, role);
		ps.setInt(6, salary);
		
		
		ps.executeUpdate();
		
		conm.closeConnection();
	}
	
	public static void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con = conm.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		while(rs.next())
		{
			System.out.println(rs.getInt("empID")+" | "+rs.getString("name")+" | "+rs.getString("email")+" | "+rs.getString("phone")+" | "+rs.getString("role")+" | "+rs.getInt("salary"));
		}
	}
	
//	public boolean updateProduct(EmployeeDetails p) throws ClassNotFoundException, SQLException
//	{
//		int prodID = p.getProdID();
//		int soldCount = p.getSoldCount();
//		
//		ConnectionManager conm = new ConnectionManager();
//		Connection con = conm.establishConnection();
//		
//		PreparedStatement st = con.prepareStatement("select quan from product where prodID = ?");
//		st.setInt(1,prodID);
//		
//		ResultSet rs = st.executeQuery();
//		//System.out.println(rs);
//		rs.next();
//		int inStock = rs.getInt(1);
//		if(inStock>=soldCount)
//		{
//			st = con.prepareStatement("update product set quan=? where prodID=?");
//			st.setInt(1,(inStock-soldCount));
//			st.setInt(2, prodID);
//			st.executeUpdate();
//			conm.closeConnection();
//			return true;
//		}
//		else
//			conm.closeConnection();
//			return false;
//	}
	
	
}
