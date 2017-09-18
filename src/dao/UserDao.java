package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.User;
import util.JDBC;

public class UserDao {
	public boolean insert(User user){
		Connection con = JDBC.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("insert into user (username,password,token,mac,logintime,lasttime,uptraffic,downtraffic,status) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getToken());
			ps.setString(4, user.getMac());
			ps.setLong(5, user.getLogintime());
			ps.setLong(6, user.getLasttime());
			ps.setLong(7, user.getUptraffic());
			ps.setLong(8, user.getDowntraffic());
			ps.setString(9, user.getStatus());
			int count = ps.executeUpdate();
			if(count==1) return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean logincheck(String username,String password){
		Connection con = JDBC.getConnection();
		boolean flag=false;
		try {
			ResultSet rs = con.createStatement().executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
			while(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean update(User user){
		Connection con = JDBC.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("update user set password=?,token=?,mac=?,logintime=?,lasttime=?,uptraffic=?,downtraffic=?,status=? where username=?");
			ps.setString(9, user.getUsername());
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getToken());
			ps.setString(3, user.getMac());
			ps.setLong(4, user.getLogintime());
			ps.setLong(5, user.getLasttime());
			ps.setLong(6, user.getUptraffic());
			ps.setLong(7, user.getDowntraffic());
			ps.setString(8, user.getStatus());
			int count = ps.executeUpdate();
			if(count==1) return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<User> query(String sql){
		Connection con = JDBC.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet rs = con.createStatement().executeQuery(sql);
			while(rs.next()){
				users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getLong(7),rs.getLong(8),rs.getLong(9),rs.getString(10)));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return users;
	}
}
