package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDao {

	DataSource ds = null;

	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String SELECT_BY_Item = "SELECT StatisticalItem, item, samples, Under2w, Over2w, Over3w,Over4w,Over5w FROM worker WHERE item=?";

	public MemberBean select(String Item) {
		MemberBean result = null;
		try (Connection conn = ds.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_Item);) {
			stmt.setString(1, Item);
			try (ResultSet rset = stmt.executeQuery();) {
				if (rset.next()) {
					result = new MemberBean();
					result.setStatisticalItem(rset.getString("StatisticalItem"));
					result.setItem(rset.getString("item"));
					result.setSamples(Integer.parseInt(rset.getString("samples")));
					result.setUnder2w(rset.getBigDecimal("Under2w"));
					result.setOver2w(rset.getBigDecimal("Over2w"));
					result.setOver3w(rset.getBigDecimal("Over3w"));
					result.setOver4w(rset.getBigDecimal("Over4w"));
					result.setOver5w(rset.getBigDecimal("Over5w"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String SELECT_ALL = "SELECT StatisticalItem, item, samples, Under2w, Over2w, Over3w,Over4w,Over5w FROM worker ORDER BY item";

	public List<MemberBean> select() {
		List<MemberBean> result = null;
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setStatisticalItem(rset.getString("StatisticalItem"));
				temp.setItem(rset.getString("item"));
				temp.setSamples(Integer.parseInt(rset.getString("samples")));
				temp.setUnder2w(rset.getBigDecimal("Under2w"));
				temp.setOver2w(rset.getBigDecimal("Over2w"));
				temp.setOver3w(rset.getBigDecimal("Over3w"));
				temp.setOver4w(rset.getBigDecimal("Over4w"));
				temp.setOver5w(rset.getBigDecimal("Over5w"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT = "Insert into worker values (?, ?, ?, ?, ?, ?, ?, ?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			stmt.setString(1, bean.getStatisticalItem());
			stmt.setString(2, bean.getItem());
			stmt.setInt(3, bean.getSamples());
			stmt.setBigDecimal(4, bean.getUnder2w());
			stmt.setBigDecimal(5, bean.getOver2w());
			stmt.setBigDecimal(6, bean.getOver3w());
			stmt.setBigDecimal(7, bean.getOver4w());
			stmt.setBigDecimal(8, bean.getOver5w());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getItem());
			}
		}
		return result;
	}

	private static final String DELETE = "DELETE FROM worker WHERE Item=?";

	public int delete(String Item) {
		int result = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETE);) {
			stmt.setString(1, Item);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE = "UPDATE worker SET StatisticalItem=?, samples=?, Under2w=?,"
			+ " Over2w=?, Over3w=?, Over4w=?, Over5w=? WHERE item=?";

	public int update(MemberBean bean) throws SQLException {
		int result = 0;
		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, bean.getStatisticalItem());			
			stmt.setInt(2, bean.getSamples());
			stmt.setBigDecimal(3, bean.getUnder2w());
			stmt.setBigDecimal(4, bean.getOver2w());
			stmt.setBigDecimal(5, bean.getOver3w());
			stmt.setBigDecimal(6, bean.getOver4w());
			stmt.setBigDecimal(7, bean.getOver5w());
			stmt.setString(8, bean.getItem());

			result = stmt.executeUpdate();
			return result;
		}
	}
}