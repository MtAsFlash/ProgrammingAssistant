package MtAs_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MtAs_DB {
//	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//导入JDBC驱动
	public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=毕业设计数据库";
	public static final String DBUSER = "sa";
	public static final String DBPASS = "MtAs1827298";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public MtAs_DB() {
		
	}

	public Statement DatabaseOpen() throws Exception {
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = conn.createStatement();

		} catch (Exception e) {
			System.err.println("OpenConn:" + e.getMessage());
		}
		return stmt;
	}

	public ResultSet exeCuteQuery(String sql) {// 执行sql查询语句

		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("excuteQuery:" + e.getMessage());
		}

		return rs;
	}

	public void executeUpdate(String sql) {// 执行sql更新语句
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stmt.executeQuery(sql);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("executeUpdate:" + e.getMessage());

		}
	}

	public void StmtClose() {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.err.println("CloseStmt:" + e.getMessage());
		}
	}

	public void ConnClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("CloseConn:" + e.getMessage());
		}
	}
}

