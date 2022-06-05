package com.survey.dao.mssqlimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

import com.survey.dao.TextDAO;
import com.survey.dto.Question;
import com.survey.dto.Text;
import com.survey.pager.PageConfig;
import com.survey.sql.ConnectionFactory;
import com.survey.sql.SQLCommand;

public class TextDAOimpl implements TextDAO {

	
	public boolean addText(Text text) {
		Connection conn = ConnectionFactory.getConnection();
		String sql = "INSERT INTO text(q_id, t_content)"
			+" VALUES(?, ?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, text.getQId());
			pstmt.setString(2, text.getTContent());
 

			return pstmt.executeUpdate()==1?true:false;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally{
			SQLCommand.close(pstmt);
			SQLCommand.close(conn);
		}
		
		
	}

	
	public boolean delText(Long sid) {
		SQLCommand cmd = new SQLCommand();
		return -1 != cmd.executeSQL("delete from text where q_id in (select q_id from question where s_id="+sid+")");
	}

	
	public Text findText(Long textId) {
		SQLCommand cmd = new SQLCommand();
		RowSet rs = cmd.queryRowSet("select * from text where t_id="
				+ textId);
		Text text=new Text();
		try {
			if (rs.next()) {
				text.setTId(rs.getLong("t_id"));
				text.setQId(rs.getLong("q_id"));
				text.setTContent(rs.getString("t_content"));
				return text;
			}

			return null;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			SQLCommand.close(rs);
		}
		return null;
	}

	
	public List<Text> listAllText(Long questionId) {
		SQLCommand cmd = new SQLCommand();
		RowSet rs = cmd.queryRowSet("select * from text where q_id="
				+ questionId);
		
		Text text;
		List<Text> list = new ArrayList<Text>();
		try {
			while (rs.next()) {
				text=new Text();
				text.setTId(rs.getLong("t_id"));
				text.setQId(rs.getLong("q_id"));
				text.setTContent(rs.getString("t_content"));
				list.add(text);
			}

			return list;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			SQLCommand.close(rs);
		}
		return null;
	}

	
	public List<?> doSelect(int recordStart, int sizePage, PageConfig pageConfig) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int getCount(PageConfig pageConfig) {
		// TODO Auto-generated method stub
		return 0;
	}

}
