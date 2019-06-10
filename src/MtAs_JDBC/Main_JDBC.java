package MtAs_JDBC;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main_JDBC {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=毕业设计数据库;";
	public Main_JDBC() {
		// TODO Auto-generated constructor stub
		try {
            // 连接数据库
            conn = DriverManager.getConnection(url, "sa", "MtAs1827298");
            // 建立Statement对象
            stmt = conn.createStatement();
            /**
             * Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
             */
            /*
            // 执行数据库查询语句
            String sql = "select * from 笔记本表";
            rs = stmt.executeQuery(sql);
            /**
             * ResultSet executeQuery(String sql) throws SQLException 执行给定的 SQL
             * 语句，该语句返回单个 ResultSet 对象
             */
            /*
            while (rs.next()) {
                String id = rs.getString("笔记名称");
                String name = rs.getString("记录时间");
                String age = rs.getString("记录内容");
                System.out.println("笔记名称:" + id + "\n记录时间:" + name + "\n记录内容:" + age);
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
            */
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
	}
	public void select_data(String sql) {
		try {
			rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	            String id = rs.getString("笔记名称");
	            String name = rs.getString("记录时间");
	            String age = rs.getString("记录内容");
	            System.out.println("笔记名称:" + id + "\n记录时间:" + name + "\n记录内容:" + age);
	        }
	        if (rs != null) {
	            rs.close();
	            rs = null;
	        }
	        if (stmt != null) {
	            stmt.close();
	            stmt = null;
	        }
	        if (conn != null) {
	            conn.close();
	            conn = null;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("数据查询失败");
	    }
	}
	public void insert_data(String sql) {
		try {
			stmt.executeUpdate(sql);//执行插入语句
            if (stmt != null) {
            	stmt.close();
            	stmt = null;
            }
            if (conn != null) {
            	conn.close();
            	conn = null;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据插入失败");
		}
	}
	public void updata_data(String sql) {
		//String sql="update users set age=20 where id=1 ";//生成一条mysql语句
		try {
			stmt.executeUpdate(sql);//执行插入语句
            if (stmt != null) {
            	stmt.close();
            	stmt = null;
            }
            if (conn != null) {
            	conn.close();
            	conn = null;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据更新失败");
		}
	}
	public void delete_data(String sql) {
		//String sql="delete from users where id=1";//生成一条sql语句
		try {
			stmt.executeUpdate(sql);//执行插入语句
            if (stmt != null) {
            	stmt.close();
            	stmt = null;
            }
            if (conn != null) {
            	conn.close();
            	conn = null;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据更新失败");
		}
	}
}