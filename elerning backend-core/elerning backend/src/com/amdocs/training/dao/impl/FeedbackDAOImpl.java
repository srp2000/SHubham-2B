package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.model.Feedback;
public class FeedbackDAOImpl implements FeedbackDAO {
	Connection conn = null;
	@Override
	public boolean saveFeedback(Feedback feedback) {
		String query = "insert into feedback values(?,?,?,?,?)";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, feedback.getUser_id());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getEmail());
			ps.setInt(4, feedback.getF_id());
			ps.setString(5, feedback.getFeedback());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
