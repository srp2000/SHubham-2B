package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.model.User;
public class UserDAOImpl implements UserDAO {
	Connection conn = null;
	@Override
	public boolean saveUser(User user) {
		String query = "insert into user values(?,?,?,?,?,?,?,?)";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user.getUser_id());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getPhone_no());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getReg_date());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getUpload_photo());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
