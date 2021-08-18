package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;
public class AdminDAOImpl implements AdminDAO {
	Connection conn = null;
	@Override
	public boolean saveAdmin(Admin admin) {
		String query = "insert into admin values(?,?,?,?)";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getEmail());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
