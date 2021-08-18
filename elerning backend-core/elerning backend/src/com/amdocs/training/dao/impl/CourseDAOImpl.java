package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.db.DBUtil;
import com.amdocs.training.model.Course;

public class CourseDAOImpl implements CourseDAO {
	Connection conn = null;
	@Override
	public boolean saveCourse(Course course) {
		String query = "insert into course values(?,?,?,?,?)";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, course.getCourse_id());
			ps.setString(2, course.getC_name());
			ps.setDouble(3, course.getC_fees());
			ps.setString(4, course.getC_desp());
			ps.setString(5, course.getC_resource());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
