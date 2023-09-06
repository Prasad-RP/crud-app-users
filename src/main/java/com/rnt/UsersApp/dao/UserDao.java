package com.rnt.UsersApp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rnt.UsersApp.controller.MainController;
import com.rnt.UsersApp.model.User;

public class UserDao {
	private static final Logger log = LogManager.getLogger(UserDao.class);
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	List<User> um = new ArrayList<User>();

	public void insertRecords(User obj) {

		try {

			/*
			 * 
			 * ps = con.
			 * prepareStatement("insert into user(name,email,address,password) values(?,?,?,?)"
			 * );
			 * 
			 * ps.setString(1, obj.getName());
			 * 
			 * ps.setString(2, obj.getEmail());
			 * 
			 * ps.setString(3, obj.getAddress()); ps.setString(4, obj.getPassword());
			 */
			con = DaoConfig.getConnection();

			String sql = "insert into user(name,email,address,password) values('" + obj.getName() + "','"
					+ obj.getEmail() + "','" + obj.getAddress() + "','" + obj.getPassword() + "');";

			ps = con.prepareStatement(sql);

			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			log.error("got a exception in insertRecords userDao"+e);
			System.out.println(e);
		}
	}

	public List<User> getUserRecords() {

		try {
			con = DaoConfig.getConnection();
			ps = con.prepareStatement("select * from user");
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));

				u.setAddress(rs.getString(4));
				u.setPassword(rs.getString(5));

				um.add(u);

			}
			ps.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			log.error("got a exception in getUserRecords Userdao"+e);
			System.out.println(e);
		}
		return um;
	}

	public int deleteUser(int id) {

		int res = 0;
		try {
			con = DaoConfig.getConnection();
			ps = con.prepareStatement("delete from user where id=" + id);
			res = ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			log.error("got a exception in deleteUser userDao"+e);
			System.out.println(e);
		}
		return res;

	}

	public int updateUser(User obj) {
		int res = 0;

		try {
			con = DaoConfig.getConnection();

			ps = con.prepareStatement("update user set name=?, email=?,address=?,password=? where id=?");

			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getAddress());
			ps.setString(4, obj.getPassword());
			ps.setInt(5, obj.getId());
			res = ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			log.error("got a exception in updateuser UserDAo "+e);
			System.out.println(e);
		}

		return res;
		/*
		 * try { String sql = "update user set name='" + obj.getName() + "',email='" +
		 * obj.getEmail() + "',address='" + obj.getAddress() + "',password='" +
		 * obj.getPassword() + "';";
		 * 
		 * ps = con.prepareStatement(sql); res = ps.executeUpdate(); } catch (Exception
		 * e) { System.out.println(e); } return res;
		 */

	}

	public User getUserById(int id) {
		User u = new User();
		try {

			con = DaoConfig.getConnection();
			ps = con.prepareStatement("select * from user where id=" + id);
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPassword(rs.getString(5));

			}
			ps.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			log.error("got a exception in getUserById UserDAo "+e);
		}
		return u;
	}

	public User getUserByEmail(String id) {
		User u = new User();
		try {
			con = DaoConfig.getConnection();

			ps = con.prepareStatement("select * from user where email='" + id + "'");
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPassword(rs.getString(5));

			}
			ps.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			log.error("got a exception in getUserByEmail UserDAo "+e);
			System.out.println(e);
		}
		return u;
	}

}
