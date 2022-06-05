package com.survey.dao.mssqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

import com.survey.dao.TempletDAO;
import com.survey.dto.Templet;
import com.survey.pager.PageConfig;
import com.survey.sql.ConnectionFactory;
import com.survey.sql.SQLCommand;

public class TempletDAOimpl implements TempletDAO {

	private List<Templet> list_templet = null;

	
	public boolean addTemplet(Templet templet) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "INSERT INTO Templet(templet_name, templet_top, templet_body,"
				+ "templet_bottom, templet_default"
				+ ") VALUES(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, templet.getTempletName());
			pstmt.setString(2, templet.getTempletTop());
			pstmt.setString(3, templet.getTempletBody());
			pstmt.setString(4, templet.getTempletBottom());
			pstmt.setBoolean(5, templet.getTempletDefault());

			return pstmt.executeUpdate()==1?true:false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	
	public boolean delTemplet(Long templetId) {
		SQLCommand cmd = new SQLCommand();
		return -1 != cmd.executeSQL("delete from templet where templet_id="
				+ templetId);
	}

	
	public Templet findTemplet(Long templetId) {
		SQLCommand cmd = new SQLCommand();
		RowSet rs = cmd.queryRowSet("select * from templet where templet_id="
				+ templetId);
		Templet templet = new Templet();
		try {
			if (rs.next()) {
				templet.setTempletId(rs.getLong("templet_id"));
				templet.setTempletName(rs.getString("templet_name"));
				templet.setTempletTop(rs.getString("templet_top"));
				templet.setTempletBody(rs.getString("templet_body"));
				templet.setTempletBottom(rs.getString("templet_bottom"));
				templet.setTempletDefault(rs.getBoolean("templet_default"));
				return templet;
			}

			return null;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	
	public List<Templet> listAllTemplet() {
		SQLCommand cmd = new SQLCommand();
		RowSet rs = cmd.queryRowSet("select * from templet");
		Templet templet;
		List<Templet> list = new ArrayList<Templet>();
		try {
			while (rs.next()) {
				templet = new Templet();
				templet.setTempletId(rs.getLong("templet_id"));
				templet.setTempletName(rs.getString("templet_name"));
				templet.setTempletTop(rs.getString("templet_top"));
				templet.setTempletBody(rs.getString("templet_body"));
				templet.setTempletBottom(rs.getString("templet_bottom"));
				templet.setTempletDefault(rs.getBoolean("templet_default"));
				list.add(templet);
			}

			return list;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	
	public boolean updateTemplet(Templet templet) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "UPDATE templet SET templet_name=?, templet_top=?, "
				+ "templet_body=?, templet_bottom=?, templet_default=? "
				+ "WHERE templet_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, templet.getTempletName());
			pstmt.setString(2, templet.getTempletTop());
			pstmt.setString(3, templet.getTempletBody());
			pstmt.setString(4, templet.getTempletBottom());
			pstmt.setBoolean(5, templet.getTempletDefault());
			pstmt.setLong(6, templet.getTempletId());

			return pstmt.executeUpdate()==1?true:false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	
	public List<?> doSelect(int recordStart, int sizePage, PageConfig pageConfig) {
		List<Templet> newlist = new ArrayList<Templet>();
		if (this.list_templet == null)
			list_templet = this.listAllTemplet();
		for (int i = recordStart; i < recordStart+sizePage; i++){
			if(i<list_templet.size())
				newlist.add(list_templet.get(i));
			else
				break;
		}
		return newlist;
	}

	
	public int getCount(PageConfig pageConfig) {
		if (this.list_templet == null)
			list_templet = this.listAllTemplet();

		return list_templet.size();
	}

}
