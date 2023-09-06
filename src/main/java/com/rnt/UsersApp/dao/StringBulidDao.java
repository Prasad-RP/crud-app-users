package com.rnt.UsersApp.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.rnt.UsersApp.model.User;

public class StringBulidDao {
	
	private static final Logger log = LogManager.getLogger(StringBulidDao.class);
	public Boolean insertUserRecords(User user) throws SQLException, PropertyVetoException {
		boolean insertStatus = false;
		StringBuilder queryString = new StringBuilder();
		PreparedStatement statement = null;
		Connection connection = DaoConfig.getConnection();
		queryString.append(" INSERT INTO user( ");
		queryString.append(" name,email,address,password)");
		queryString.append(" VALUES(?,?,?,?)");
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(queryString.toString());
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getPassword());
			statement.addBatch();
			
			int[] rowsInserted = statement.executeBatch();
			if (rowsInserted.length > 0) {
				connection.commit();
				insertStatus = true;
			}
		} catch (Exception e) {
			log.error("Got exception in insert...",e);
		} finally {
		}
		return insertStatus;
	}

	public List<User> getUserRecords() throws SQLException, PropertyVetoException {
		List<User> userList = new ArrayList<User>();
		StringBuilder queryString = new StringBuilder();
		PreparedStatement statement = null;
		ResultSet rs = null;
		Connection connection = DaoConfig.getConnection();
		queryString.append(" SELECT * FROM user");
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(queryString.toString());
			rs = statement.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPassword(rs.getString(5));
				userList.add(u);
			}
		} catch (Exception e) {
			log.error("got a exception in getUserRecords "+e);
		} finally {
			statement.close();
			rs.close();
			connection.commit();
		}
		return userList;
	}

	public Boolean updateUserRecords(User user) throws SQLException, PropertyVetoException {
		boolean insertStatus = false;
		StringBuilder queryString = new StringBuilder();
		PreparedStatement statement = null;
		Connection connection = DaoConfig.getConnection();
		queryString.append(" UPDATE user SET");
		queryString.append(" name=?,");
		queryString.append(" email=?,");
		queryString.append(" address=?,");
		queryString.append(" password=?");
		queryString.append(" WHERE id=?");
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(queryString.toString());

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getAddress());
			statement.setString(4, user.getPassword());
			statement.setInt(5, user.getId());
			statement.addBatch();

			int[] rowsInserted = statement.executeBatch();
			if (rowsInserted.length > 0) {
				connection.commit();
				insertStatus = true;

			}
		} catch (Exception e) {
			log.error("got a exception in updateUserRecords "+e);
			System.out.println(e);
		} finally {
			statement.close();
			connection.commit();
		}
		return insertStatus;
	}

}
